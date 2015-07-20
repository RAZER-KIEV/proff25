package hw7.notes.view;

import hw7.notes.Main;
import hw7.notes.service.NotebookService;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.LinkedList;

public class NSMenu extends Application {

    private NotebookService service;
    private Stage primaryStage;
    private BorderPane borderPane;
    private TabPane tabPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        service = Main.getService();
        this.primaryStage = primaryStage;
        borderPane = new BorderPane();
        tabPane = new TabPane();
        borderPane.setTop(tabPane);
        Tab mainTab = new Tab("Main menu", mainButtonsBox());
        mainTab.setClosable(false);
        tabPane.getTabs().add(mainTab);
        Scene scene = new Scene(borderPane,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public VBox mainButtonsBox() {
        VBox vBox = new VBox();
        Collection<Button> buttons = new LinkedList<>();
        Button newVendorButton = new Button("Create vendor");
        buttons.add(newVendorButton);
        newVendorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Tab tab;
                if ((tab = handleHelper(event)) != null) {
                    tab.setContent(new CreateVendor(service).getBox());
                }
            }
        });
        Button newCPUButton = new Button("Create CPU");
        buttons.add(newCPUButton);
        newCPUButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Tab tab;
                if ((tab = handleHelper(event)) != null) {
                    tab.setContent(new CreateCPU(service).getBox());
                }
            }
        });
        Button newCreateMemoryButton = new Button("Create Memory");
        buttons.add(newCreateMemoryButton);
        newCreateMemoryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Tab tab;
                if ((tab = handleHelper(event)) != null) {
                    tab.setContent(new CreateMemory().getIt());
                }
            }
        });
        Button newCreateNotebookButton = new Button("Create Notebook");
        buttons.add(newCreateNotebookButton);
        newCreateNotebookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Tab tab;
                if ((tab = handleHelper(event)) != null) {
                    tab.setContent(new CreateNotebook().getIt());
                }
            }
        });
        Button newReceiveNotebookButton = new Button("Receive Notebooks");
        buttons.add(newReceiveNotebookButton);
        newReceiveNotebookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Tab tab;
                if ((tab = handleHelper(event)) != null) {
                    tab.setContent(new CreateStore(service).getBox());
                }
            }
        });
        buttons.forEach(button -> button.setPrefWidth(150));
        vBox.getChildren().addAll(buttons);
        return vBox;
    }

    private Tab handleHelper(ActionEvent event) {
        Button button = (Button) event.getSource();
        String text = button.getText();
        int tabIndex = checkIfExist(text);
        if (tabIndex != -1) {
            tabPane.getSelectionModel().select(tabIndex);
            return null;
        }
        Tab createVendorTab = new Tab(text);
        tabPane.getTabs().add(createVendorTab);
        tabPane.getSelectionModel().select(createVendorTab);
        return createVendorTab;
    }

    private int checkIfExist(String tabName) {
        ObservableList<Tab> tabs = tabPane.getTabs();
        for (int i = 0; i < tabs.size(); i++) {
            if (tabs.get(i).getText().equals(tabName)) {
                return i;
            }
        }
        return -1;
    }

}
