package hw7.notes.service;/**
 * Created by GFalcon on 28.06.15.
 */

import hw7.notes.domain.CPU;
import hw7.notes.domain.Vendor;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Menu extends Application {
    private BorderPane viewPanel = new BorderPane();
    private BorderPane controlPanel = new BorderPane();
    private BorderPane mainPanel = new BorderPane();
    private NotebookServiceImpl service = new NotebookServiceImpl();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Notebook stock");
        Scene scene = new Scene(mainPanel, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        javafx.scene.control.Menu menuCreate = new javafx.scene.control.Menu("Create");
        MenuItem crVendor = new MenuItem("Create Vendor");
        crVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createVendor();
            }
        });
        MenuItem crCPU = new MenuItem("Create CPU");
        crCPU.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createCPU();
            }
        });
        MenuItem crMemory = new MenuItem("Create Memory");
        crMemory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createMemory();
            }
        });
        MenuItem crNotebook = new MenuItem("Create Notebook");
        crNotebook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createNotebook();
            }
        });
        MenuItem crReceive = new MenuItem("To take to the warehouse party notebook");
        crReceive.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                receive();
            }
        });
        MenuItem crSale = new MenuItem("Sale");
        crSale.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sale();
            }
        });
        menuCreate.getItems().addAll(
                crVendor,
                crCPU,
                crMemory,
                crNotebook,
                new SeparatorMenuItem(),
                crReceive,
                crSale
        );

        viewPanel.setCenter(new Label("NOTEBOOK STOCK DATABASE"));

        javafx.scene.control.Menu menuUpdate = new javafx.scene.control.Menu("Update");
        MenuItem upCPU = new MenuItem("Update CPU");
        upCPU.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateCPU();
            }
        });
        MenuItem upMemory = new MenuItem("Update Memory");
        upMemory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateMemory();
            }
        });
        MenuItem upVendor = new MenuItem("Update Vendor");
        upVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateVendor();
            }
        });
        MenuItem upNotebook = new MenuItem("Update Notebook");
        upNotebook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateNotebook();
            }
        });
        MenuItem upStore = new MenuItem("Remove from store");
        upStore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                removeFromStore();
            }
        });
        menuUpdate.getItems().addAll(
                upVendor,
                upCPU,
                upMemory,
                upNotebook,
                new SeparatorMenuItem(),
                upStore
        );

        controlPanel.setCenter(new Label("by Aleksey ''GFalcon'' KHALIKOV"));

        javafx.scene.control.Menu menuReport = new javafx.scene.control.Menu("Report");
        MenuItem gtNoteByPortion = new MenuItem("Get Notebooks by portion");
        gtNoteByPortion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getNotebooksByPortion();
            }
        });
        MenuItem gtNotebooksGtAmount = new MenuItem("getNotebooksGtAmount");
        gtNotebooksGtAmount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getNotebooksGtAmount();
            }
        });
        MenuItem gtNotebooksByCpuVendor = new MenuItem("getNotebooksByCpuVendor");
        gtNotebooksByCpuVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getNotebooksByCpuVendor();
            }
        });
        MenuItem gtNotebooksFromStore = new MenuItem("getNotebooksFromStore");
        gtNotebooksFromStore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getNotebooksFromStore();
            }
        });
        MenuItem gtNotebooksStorePresent = new MenuItem("getNotebooksStorePresent");
        gtNotebooksStorePresent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getNotebooksStorePresent();
            }
        });
        MenuItem gtSalesByDays = new MenuItem("getSalesByDays");
        gtSalesByDays.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getSalesByDays();
            }
        });
        menuReport.getItems().addAll(
                gtNoteByPortion,
                gtNotebooksGtAmount,
                gtNotebooksByCpuVendor,
                gtNotebooksFromStore,
                gtNotebooksStorePresent,
                new SeparatorMenuItem(),
                gtSalesByDays
        );

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(
                menuCreate,
                menuUpdate,
                menuReport
        );

        mainPanel.setTop(menuBar);
        mainPanel.setCenter(viewPanel);
        mainPanel.setBottom(controlPanel);
    }

    private void createVendor(){
        // Создать производителя

        TextField txtVendorName = new TextField();
        Button btnCreateVendor = new Button("Create");
        controlPanel.setCenter(txtVendorName);
        controlPanel.setLeft(new Label("Enter new vendor name "));
        controlPanel.setRight(btnCreateVendor);

        TableView<Vendor> table = new TableView<Vendor>();

        TableColumn idColumn = new TableColumn("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<Vendor, Long>("id"));
        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Vendor, String>("name"));
        table.getColumns().addAll(idColumn, nameColumn);

        ObservableList<Vendor> vendors = FXCollections.observableArrayList(service.getVendorsList());
        table.setItems(vendors);
        viewPanel.setTop(new Label("Vendors list"));
        viewPanel.setCenter(table);

        btnCreateVendor.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!txtVendorName.getText().isEmpty()){
                    Vendor newVendor = new Vendor();
                    newVendor.setName(txtVendorName.getText());
                    service.createVendor(newVendor);
                }
            }
        });
    }

    private void createCPU(){
        // Создать процессор

/*
        TableView<CPU> cpuTableView = new TableView<CPU>();
        TableColumn cId = new TableColumn("id");
        cId.setCellValueFactory(new PropertyValueFactory<CPU, Long>("id"));
        TableColumn cVendor= new TableColumn("Vendor");
        cVendor.setCellValueFactory(new PropertyValueFactory<Vendor, Vendor>("vendor"));
        TableColumn cFrequency = new TableColumn("Frequency");
        cFrequency.setCellValueFactory(new PropertyValueFactory<CPU, Double>("frequency"));
        TableColumn cModel = new TableColumn("Model");
        cModel.setCellValueFactory(new PropertyValueFactory<CPU, String>("model"));
        cpuTableView.getColumns().addAll(cId, cVendor, cFrequency, cModel);
        ObservableList<CPU> cpus = FXCollections.observableArrayList(service.getCPUList());
        cpuTableView.setItems(cpus);
        viewPanel.setCenter(cpuTableView);
        viewPanel.setTop(new Label("CPU list"));
*/
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        viewPanel.setCenter(textArea);
        viewPanel.setTop(new Label("CPU list"));
        ArrayList<CPU> cpus = (ArrayList)service.getCPUList();
        for (int i = 0; i < cpus.size(); i++){
            textArea.appendText(cpus.get(i).toString());
            textArea.appendText("\n");
        }

        TextArea txtVendors = new TextArea();
        txtVendors.setEditable(false);
        viewPanel.setRight(txtVendors);
        txtVendors.appendText("All Vendors list: \n");
        ArrayList<Vendor> vendorArrayList = (ArrayList)service.getVendorsList();
        for (int i = 0; i < vendorArrayList.size(); i++){
            txtVendors.appendText(vendorArrayList.get(i).toString());
            txtVendors.appendText("\n");
        }

    }

    private void createMemory(){
        // Создать память

    }

    private void createNotebook(){
        // Создать тип ноутбука

    }

    private void receive(){
        // Принять на склад партию ноутбуков (тип ноутбука, количество, цена)

    }

    private void sale(){
        // Продать указанное количество ноутбуков со склада(id склада, количество)

    }

    private void updateCPU(){
        // Изменить процессор

    }

    private void updateMemory(){
        // Изменить память

    }

    private void updateVendor(){
        // Изменить имя производителя

    }

    private void updateNotebook(){
        // Изменить тип ноутбука

    }

    private void removeFromStore(){
        // Списать со склад ноутбуки (ключ, количество)

    }

    private void getNotebooksByPortion(){
        // Показать все ноутбуки на складе (пользователь указывает размер порции)

    }

    private void getNotebooksGtAmount(){
        // Показать все ноутбуки которых больше указанного количества

    }

    private void getNotebooksByCpuVendor(){
        // Показать все ноутбуки по указанному имени производителя процессора

    }

    private void getNotebooksFromStore(){
        // Показать все ноутбуки на складе

    }

    private void getNotebooksStorePresent(){
        // Показать типы ноутбуков, оставшиеся на складе по каждому производителю

    }

    private void getSalesByDays(){
        // Получить объем продаж ноутбуков в среднем за день

    }
}
