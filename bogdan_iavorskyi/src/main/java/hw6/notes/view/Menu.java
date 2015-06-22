package hw6.notes.view;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.List;

/*
 * Created on 18.06.15.
 */
public class Menu extends Application {

    private NotebookService service;

    private Stage primaryStage;
    private BorderPane rootLayout;
    private VBox mainMenu;

    private static String title = "Notebook Service";
    private static GridPane headerDataPane;
    private GridPane paneForAddingNewNotebook;
    private Button addDoWorkButton;

    public void main() {
        service = new NotebookServiceImpl();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        main();
        Menu.headerDataPane = initHeaderData();
        addDoWorkButton = generateAddDoWorkButton();

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(title);
        this.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                service.closeFactory();
            }
        });

        initRootLayout();
        initMainMenu();

        this.primaryStage.show();
    }

    public void initRootLayout() {
        rootLayout = new BorderPane();

        Scene scene = new Scene(rootLayout,800,600);
        primaryStage.setScene(scene);
    }

    public void initMainMenu() {
        mainMenu = new VBox();
        mainMenu.getChildren().addAll(createAddMenuButton(), createListMenuButton());

        rootLayout.setLeft(mainMenu);
    }

    public GridPane initHeaderData() {
        GridPane pane = new GridPane();
        pane.add(new TextField("Id"),0,0);
        pane.add(new TextField("Vendor"),1,0);
        pane.add(new TextField("Model"),2,0);
        pane.add(new TextField("SerialNumber"),3,0);
        pane.add(new TextField("ManufactureDate"),4,0);
        pane.add(new TextField("Price"),5,0);
        return pane;
    }

    public Button createAddMenuButton() {
        Button addNewNotebook = new Button("Add");

        addNewNotebook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GridPane pane = showAddView();
                primaryStage.setTitle(title + ".AddNew");
                rootLayout.setCenter(pane);
            }
        });

        return addNewNotebook;
    }

    public Button createListMenuButton() {
        Button listAllNotebooks = new Button("List");

        listAllNotebooks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GridPane pane = generateGridPaneWithHeader(listAll());
                primaryStage.setTitle(title + ".ListAll");
                rootLayout.setCenter(pane);
            }
        });

        return listAllNotebooks;
    }

    public GridPane listAll() {
        List<Notebook> notebooks = service.findAll();
        GridPane pane = new GridPane();
        for (int j = 0; j < notebooks.size(); j++) {
            Notebook notebook = notebooks.get(j);
            Object obj;
            System.out.println((obj = notebook.getId()) == null ? "" : obj.toString());
            pane.add(new TextField(notebook.getId().toString()), 0, j);
            pane.add(new TextField(notebook.getVendor()),1,j);
            pane.add(new TextField(notebook.getModel()),2,j);
            pane.add(new TextField(notebook.getSerialNumber()),3,j);
            pane.add(new TextField((obj = notebook.getManufactureDate()) == null ? "" : obj.toString()),4,j);
            pane.add(new TextField((obj = notebook.getPrice()) == null ? "" : obj.toString()),5,j);
        }
        return pane;
    }

    public GridPane showAddView() {
        GridPane pane = new GridPane();
        generateEmptyGridPaneForText();
        pane.add(headerDataPane,0,1);
        pane.add(paneForAddingNewNotebook,0,2);
        pane.add(addDoWorkButton,0,3);
        return pane;
    }

    public GridPane generateGridPaneWithHeader(Node node) {
        GridPane pane = new GridPane();
        pane.add(headerDataPane,0,0);
        pane.add(node,0,1);
        return pane;
    }

    public void generateEmptyGridPaneForText() {
        GridPane pane = new GridPane();
        TextField field;
        for (int i = 0; i < 6; i++) {
            field = new TextField();
            if (i == 0) {
                field.setEditable(false);
            }
            pane.add(field, i, 0);
        }
        paneForAddingNewNotebook = pane;
    }

    public Button generateAddDoWorkButton() {
        Button button = new Button("Add");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Notebook notebook = new Notebook();
                GridPane pane = paneForAddingNewNotebook;
                TextField field;
                field = (TextField) pane.getChildren().get(1);
                notebook.setVendor(field.getText());
                service.add(notebook);
            }
        });
        return button;
    }

}
