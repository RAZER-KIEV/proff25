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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/*
 * Created on 18.06.15.
 */
public class Menu extends Application {

    private NotebookService service;

    private Stage primaryStage;
    private BorderPane rootLayout;
    private VBox mainMenu;
    private GridPane deleteSubMenu;
    private GridPane modifySubMenu;
    private Button backToMainMenuButton;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

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
        backToMainMenuButton = generateBackToMainMenuButton();

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
        mainMenu.getChildren().addAll(createAddMenuButton(), createListMenuButton(),
                createModifyMenuButton(), createDeleteMenuButton());

        rootLayout.setLeft(mainMenu);
    }

    public GridPane initHeaderData() {
        GridPane pane = new GridPane();
        pane.add(new TextField("Id"),0,0);
        pane.add(new TextField("Vendor"),1,0);
        pane.add(new TextField("Model"),2,0);
        pane.add(new TextField("SerialNumber"),3,0);
        pane.add(new TextField("Date"),4,0);
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

    public Button createModifyMenuButton() {
        Button modifyNotebooks = new Button("Modify");

        modifyNotebooks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (modifySubMenu == null) {
                    modifySubMenu = generateModifySubMenu();
                }
                rootLayout.setCenter(null);
                rootLayout.setLeft(modifySubMenu);
            }
        });

        return modifyNotebooks;
    }

    public Button createDeleteMenuButton() {
        Button deleteNotebooks = new Button("Delete");

        deleteNotebooks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (deleteSubMenu == null) {
                    deleteSubMenu  = generateDeleteSubMenu();
                }
                rootLayout.setCenter(null);
                rootLayout.setLeft(deleteSubMenu);
            }
        });

        return deleteNotebooks;
    }

    public GridPane listAll() {
        List<Notebook> notebooks = service.findAll();
        GridPane pane = new GridPane();
        for (int j = 0; j < notebooks.size(); j++) {
            Notebook notebook = notebooks.get(j);
            Object obj;
            pane.add(new TextField(notebook.getId().toString()), 0, j);
            pane.add(new TextField(notebook.getVendor()),1,j);
            pane.add(new TextField(notebook.getModel()),2,j);
            pane.add(new TextField(notebook.getSerialNumber()),3,j);
            pane.add(new TextField((obj = notebook.getManufactureDate()) == null ? "" : dateFormat.format(obj)),4,j);
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
                field = (TextField) pane.getChildren().get(2);
                notebook.setModel(field.getText());
                field = (TextField) pane.getChildren().get(3);
                notebook.setSerialNumber(field.getText());
                field = (TextField) pane.getChildren().get(4);
                try {
                    notebook.setManufactureDate(dateFormat.parse(field.getText()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                field = (TextField) pane.getChildren().get(5);
                notebook.setPrice(new Double(field.getText()));

                service.add(notebook);
            }
        });
        return button;
    }

    public void deleteNtb() {
        FlowPane pane = new FlowPane();
        Label id = new Label("Id");
        TextField idTextField = new TextField();
        Button deleteButton = new Button("Delete");
        deleteButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String message;
                if (service.delete(new Long(idTextField.getText()))) {
                    message = "Success";
                } else {
                    message = "Failed";
                }
                rootLayout.setBottom(new Label(message));
            }
        });
        pane.getChildren().addAll(id, idTextField, deleteButton);
        rootLayout.setCenter(pane);
    }
    public void changePrice() {
        FlowPane paneId = new FlowPane();
        Label id = new Label("Id");
        TextField idTextField = new TextField();
        paneId.getChildren().addAll(id, idTextField);
        FlowPane panePrice = new FlowPane();
        Label price = new Label("Price");
        TextField priceTextField = new TextField();
        panePrice.getChildren().addAll(price,priceTextField);
        FlowPane buttonPane = new FlowPane();
        Button changeButton = new Button("Modify");
        changeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                service.changePrice(new Long(idTextField.getText()), new Double(priceTextField.getText()));
            }
        });
        buttonPane.getChildren().add(changeButton);
        GridPane pane = new GridPane();
        pane.add(paneId,0,0);
        pane.add(panePrice,0,1);
        pane.add(buttonPane,0,2);
        rootLayout.setCenter(pane);

    }
    public void changeSerialVendor() {
        FlowPane paneId = new FlowPane();
        Label id = new Label("Id");
        TextField idTextField = new TextField();
        paneId.getChildren().addAll(id, idTextField);
        FlowPane serialPane = new FlowPane();
        Label serial = new Label("Serial");
        TextField serialTextField = new TextField();
        serialPane.getChildren().addAll(serial,serialTextField);
        FlowPane vendorPane = new FlowPane();
        Label vendor = new Label("Vendor");
        TextField vendorTextField = new TextField();
        vendorPane.getChildren().addAll(vendor,vendorTextField);
        FlowPane buttonPane = new FlowPane();
        Button changeButton = new Button("Modify");
        changeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                service.changeSerialVendor(new Long(idTextField.getText()),
                        serialTextField.getText(),
                        vendorTextField.getText());
            }
        });
        buttonPane.getChildren().add(changeButton);
        GridPane pane = new GridPane();
        pane.add(paneId,0,0);
        pane.add(vendorPane,0,1);
        pane.add(serialPane,0,2);
        pane.add(buttonPane,0,3);
        rootLayout.setCenter(pane);
    }

    public GridPane generateDeleteSubMenu() {
        GridPane pane = new GridPane();
        pane.add(generateDeleteByIdButton(),0,0);
        pane.add(backToMainMenuButton,0,1);
        return pane;
    }

    public GridPane generateModifySubMenu() {
        GridPane pane = new GridPane();
        pane.add(generateModifyPriceByIdButton(),0,0);
        pane.add(generateModifyVendorAndSNByIdButton(),0,1);
        pane.add(backToMainMenuButton,0,2);
        return pane;
    }

    public Button generateBackToMainMenuButton() {
        Button button = new Button("Back");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setTitle(title);
                rootLayout.setCenter(null);
                rootLayout.setBottom(null);
                rootLayout.setLeft(mainMenu);
            }
        });
        return button;
    }

    public Button generateModifyPriceByIdButton() {
        Button button = new Button("Mod Price\nby Id");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setTitle(title + ".ModifyPriceById");
                changePrice();
            }
        });
        return button;
    }

    public Button generateModifyVendorAndSNByIdButton() {
        Button button = new Button("Mod Vendor\nand S/N\nby Id");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setTitle(title + ".ModifyVendorAndS/NById");
                changeSerialVendor();
            }
        });
        return button;
    }

    public Button generateDeleteByIdButton() {
        Button button = new Button("Del by Id");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setTitle(title + ".DeleteById");
                deleteNtb();
            }
        });
        return button;
    }

}
