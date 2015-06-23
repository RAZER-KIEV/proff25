package hw6.notes.fx;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.util.HibernateUtil;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Menu extends Application{
    private static final int WIDTH = 600;
    private static final int HEIGTH = 400;
    private HibernateUtil hibernateUtil;
    private NotebookServiceImpl notebookService;

    public Menu(){
        Locale.setDefault(Locale.ENGLISH);
        hibernateUtil = new HibernateUtil();
        hibernateUtil.createSessionFactory();

        notebookService = new NotebookServiceImpl(hibernateUtil.getFactory());
    }

    public void close(){
        hibernateUtil.closeFactory();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = new BorderPane();
        borderPane.setMinWidth(WIDTH);
        Scene scene = new Scene(borderPane, WIDTH, HEIGTH);
        Button buttonFindAll = new Button("Find all");
        buttonFindAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableView<Notebook> notebookTableView = createTableView(notebookService.findAll());
                notebookTableView.setMinWidth(WIDTH);
                notebookTableView.setMaxWidth(WIDTH);
                borderPane.setCenter(notebookTableView);
            }
        });

        Button buttonfindByVendor = new Button("Find by vendor");
        buttonfindByVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                stage.setTitle("Find by vendor");
                stage.setMinWidth(300);
                stage.setMinHeight(100);
                Button okButton = new Button("OK");
                TextField vendor = new TextField();
                Label label = new Label("Enter name of vendor");
                vendor.setPromptText("Enter name of vendor");
                BorderPane borderPane1 = new BorderPane();
                borderPane1.setTop(label);
                borderPane1.setCenter(vendor);
                borderPane1.setBottom(okButton);
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (vendor.getText()!="") {
                            TableView<Notebook> notebookTableView = createTableView(notebookService.findByVendor(vendor.getText()));
                            notebookTableView.setMinWidth(WIDTH);
                            notebookTableView.setMaxWidth(WIDTH);
                            borderPane.setCenter(notebookTableView);
                            stage.close();
                        }
                    }
                });
                Scene scene1 = new Scene(borderPane1);
                stage.setScene(scene1);
                stage.showAndWait();
            }
        });

        Button buttonfindByPriceManufDate = new Button("Find by price and date");
        buttonfindByPriceManufDate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                stage.setTitle("Find by price and date");
                stage.setMinWidth(300);
                stage.setMinHeight(100);
                stage.setResizable(false);
                Button okButton = new Button("OK");
                okButton.setMinWidth(300);
                TextField price = new TextField();
                price.setMinWidth(150);
                price.setPromptText("Enter price");
                Label labelPrice = new Label("Enter price");
                labelPrice.setMinWidth(150);
                TextField date = new TextField();
                date.setMinWidth(150);
                date.setPromptText("Enter date");
                Label labelDate = new Label("Enter date");
                labelDate.setMinWidth(150);
                BorderPane borderPane1 = new BorderPane();
                borderPane1.setTop(new FlowPane(labelPrice,labelDate));
                borderPane1.setCenter(new FlowPane(price, date));
                borderPane1.setBottom(okButton);
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (price.getText()!="" && date.getText()!="") {
                            TableView<Notebook> notebookTableView = null;
                            try {
                                notebookTableView = createTableView(notebookService.findByPriceManufDate(
                                        Double.parseDouble(price.getText()), new SimpleDateFormat("dd.MM.yyyy").parse(date.getText())));
                            } catch (ParseException e) {
                            }
                            notebookTableView.setMinWidth(WIDTH);
                            notebookTableView.setMaxWidth(WIDTH);
                            borderPane.setCenter(notebookTableView);
                            stage.close();
                        }
                    }
                });
                Scene scene1 = new Scene(borderPane1, 300,100);
                stage.setScene(scene1);
                stage.showAndWait();
            }
        });
        Button buttonfindBetweenPriceLtDateByVendor = new Button("Find between price");
        buttonfindBetweenPriceLtDateByVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                stage.setTitle("Find between price, date and vendor");
                stage.setMinWidth(300);
                stage.setMinHeight(100);
                stage.setResizable(false);
                Button okButton = new Button("OK");
                okButton.setMinWidth(300);
                TextField startPrice = new TextField();
                startPrice.setMinWidth(150);
                startPrice.setPromptText("Start price");
                Label labelStartPrice = new Label("Start price");
                labelStartPrice.setMinWidth(150);
                TextField finishPrice = new TextField();
                finishPrice.setMinWidth(150);
                finishPrice.setPromptText("Start price");
                Label labelFinishPrice = new Label("Start price");
                labelFinishPrice.setMinWidth(150);
                TextField date = new TextField();
                date.setMinWidth(150);
                date.setPromptText("Enter date");
                Label labelDate = new Label("Enter date");
                labelDate.setMinWidth(150);
                TextField vendor = new TextField();
                vendor.setMinWidth(150);
                vendor.setPromptText("Enter vendor");
                Label labelVendor = new Label("Enter vendor");
                labelVendor.setMinWidth(150);
                BorderPane borderPane1 = new BorderPane();
                BorderPane borderPane2 = new BorderPane();
                borderPane2.setTop(new FlowPane(labelStartPrice,labelFinishPrice));
                borderPane2.setCenter(new FlowPane(startPrice, finishPrice));
                borderPane2.setBottom(new FlowPane(labelDate, labelVendor));
                borderPane1.setTop(borderPane2);
                borderPane1.setCenter(new FlowPane(date,vendor));
                borderPane1.setBottom(okButton);
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (startPrice.getText()!="" && date.getText()!="" && finishPrice.getText()!="" && vendor.getText()!="") {
                            TableView<Notebook> notebookTableView = null;
                            try {
                                notebookTableView = createTableView(notebookService.findBetweenPriceLtDateByVendor(
                                        Double.parseDouble(startPrice.getText()), Double.parseDouble(finishPrice.getText()),
                                        new SimpleDateFormat("dd.MM.yyyy").parse(date.getText()),vendor.getText()));
                            } catch (ParseException e) {
                            }
                            notebookTableView.setMinWidth(WIDTH);
                            notebookTableView.setMaxWidth(WIDTH);
                            borderPane.setCenter(notebookTableView);
                            stage.close();
                        }
                    }
                });
                Scene scene1 = new Scene(borderPane1, 300,100);
                stage.setScene(scene1);
                stage.showAndWait();
            }
        });

        borderPane.setTop(new FlowPane(buttonFindAll,buttonfindByVendor,buttonfindByPriceManufDate,buttonfindBetweenPriceLtDateByVendor));

        //primaryStage.setResizable(false);
        primaryStage.setTitle("Notebook service");
        primaryStage.setScene(scene);
        primaryStage.show();


        TextField addSerial = new TextField();
        addSerial.setMinWidth(WIDTH * 0.2);
        addSerial.setPromptText("Serial");
        addSerial.setMaxWidth(WIDTH * 0.2);
        TextField addVendor = new TextField();
        addVendor.setMinWidth(WIDTH * 0.1);
        addVendor.setPromptText("Vendor");
        addVendor.setMaxWidth(WIDTH * 0.1);
        TextField addModel = new TextField();
        addModel.setMinWidth(WIDTH * 0.2);
        addModel.setPromptText("Model");
        addModel.setMaxWidth(WIDTH * 0.2);
        TextField addDate = new TextField();
        addDate.setMinWidth(WIDTH * 0.2);
        addDate.setPromptText("Manufacture date");
        addDate.setMaxWidth(WIDTH * 0.2);
        TextField addPrice = new TextField();
        addPrice.setMinWidth(WIDTH * 0.1);
        addPrice.setPromptText("Price");
        addPrice.setMaxWidth(WIDTH * 0.1);
        Button addButton = new Button("Add");
        addButton.setMinWidth(WIDTH * 0.1);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Date date = null;
                try {
                    date = new SimpleDateFormat("dd.MM.yyyy").parse(addDate.getText());
                } catch (ParseException e) {
                }
                Notebook notebook = new Notebook(addSerial.getText(), addVendor.getText(), addModel.getText(), date, Double.parseDouble(addPrice.getText()));
                addDate.clear();
                addModel.clear();
                addPrice.clear();
                addSerial.clear();
                addVendor.clear();
                notebook.print();
                notebookService.add(notebook);
                TableView<Notebook> notebookTableView = createTableView(notebookService.findAll());
                notebookTableView.setMinWidth(WIDTH);
                notebookTableView.setMaxWidth(WIDTH);
                borderPane.setCenter(notebookTableView);
            }
        });

        BorderPane borderPane1 = new BorderPane();

        borderPane1.setTop(new FlowPane(addButton, addSerial, addVendor, addModel, addDate, addPrice));

        TextField deleteId = new TextField();
        deleteId.setMinWidth(WIDTH * 0.1);
        deleteId.setPromptText("ID");
        deleteId.setMaxWidth(WIDTH * 0.1);
        TextField deleteModel = new TextField();
        deleteModel.setMinWidth(WIDTH * 0.1);
        deleteModel.setPromptText("Model");
        deleteModel.setMaxWidth(WIDTH * 0.1);
        Button deleteButton = new Button("Delete");
        deleteButton.setMinWidth(WIDTH * 0.1);
        borderPane1.setCenter(new FlowPane(deleteButton, deleteId, deleteModel));
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!deleteId.getText().equals("")) {
                    notebookService.delete(Long.parseLong(deleteId.getText()));
                    deleteId.clear();
                    TableView<Notebook> notebookTableView = createTableView(notebookService.findAll());
                    notebookTableView.setMinWidth(WIDTH);
                    notebookTableView.setMaxWidth(WIDTH);
                    borderPane.setCenter(notebookTableView);
                } else if (!deleteModel.getText().equals("")) {
                    notebookService.deleteByModel(deleteModel.getText());
                    deleteModel.clear();
                    TableView<Notebook> notebookTableView = createTableView(notebookService.findAll());
                    notebookTableView.setMinWidth(WIDTH);
                    notebookTableView.setMaxWidth(WIDTH);
                    borderPane.setCenter(notebookTableView);
                }

            }
        });

        TextField changeId = new TextField();
        changeId.setMinWidth(WIDTH * 0.1);
        changeId.setPromptText("ID");
        changeId.setMaxWidth(WIDTH * 0.1);
        TextField changePrice = new TextField();
        changePrice.setMinWidth(WIDTH * 0.1);
        changePrice.setPromptText("Price");
        changePrice.setMaxWidth(WIDTH * 0.1);
        TextField changeSerial = new TextField();
        changeSerial.setMinWidth(WIDTH * 0.2);
        changeSerial.setPromptText("Serial");
        changeSerial.setMaxWidth(WIDTH * 0.2);
        TextField changeVendor = new TextField();
        changeVendor.setMinWidth(WIDTH * 0.1);
        changeVendor.setPromptText("Vendor");
        changeVendor.setMaxWidth(WIDTH * 0.1);
        Button changeButton = new Button("Change");
        changeButton.setMinWidth(WIDTH * 0.1);
        borderPane1.setBottom(new FlowPane(changeButton, changeId, changeSerial, changeVendor, changePrice));
        changeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (changeId.getText() != "") {
                    if (changePrice.getText() != "") {
                        notebookService.changePrice(Long.parseLong(changeId.getText()), Double.parseDouble(changePrice.getText()));
                        changePrice.clear();
                        changeId.clear();
                        TableView<Notebook> notebookTableView = createTableView(notebookService.findAll());
                        notebookTableView.setMinWidth(WIDTH);
                        notebookTableView.setMaxWidth(WIDTH);
                        borderPane.setCenter(notebookTableView);
                    } else {
                        if (changeSerial.getText() != "" && changeVendor.getText() != "") {
                            notebookService.changeSerialVendor(Long.parseLong(changeId.getText()), changeSerial.getText(),changeVendor.getText());
                            changeSerial.clear();;
                            changeVendor.clear();
                            changeId.clear();
                            TableView<Notebook> notebookTableView = createTableView(notebookService.findAll());
                            notebookTableView.setMinWidth(WIDTH);
                            notebookTableView.setMaxWidth(WIDTH);
                            borderPane.setCenter(notebookTableView);
                        }
                    }
                }
            }
        });

        borderPane.setBottom(borderPane1);

        primaryStage.setOnCloseRequest(event -> {
            close();
        });
    }

    private TableView<Notebook> createTableView(List<Notebook> notebookList){
        ObservableList<Notebook> notebookObservableList = FXCollections.observableList(notebookList);
        TableView<Notebook> notebookTableView = new TableView<>();
        notebookTableView.setItems(notebookObservableList);

        TableColumn id = new TableColumn("id");
        id.setMinWidth(WIDTH * 0.1);
        id.setSortType(TableColumn.SortType.DESCENDING);
        id.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("id")
        );
        TableColumn serial = new TableColumn("Serial");
        serial.setMinWidth(WIDTH * 0.2);
        serial.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("Serial")
        );
        TableColumn vendor = new TableColumn("Vendor");
        vendor.setMinWidth(WIDTH * 0.1);
        vendor.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("Vendor")
        );
        TableColumn model = new TableColumn("Model");
        model.setMinWidth(WIDTH * 0.2);
        model.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("model")
        );
        TableColumn date = new TableColumn("Manufacture date");
        date.setMinWidth(WIDTH * 0.2);
        date.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("manufactureDate")
        );
        TableColumn price = new TableColumn("Price");
        price.setMinWidth(WIDTH*0.2);
        price.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("Price")
        );
        notebookTableView.getColumns().addAll(id, serial, vendor, model, date, price);
        return notebookTableView;
    }

}
