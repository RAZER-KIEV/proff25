package hw6.notes.service;


import hw6.notes.domain.Notebook;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.util.HibernateUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Роман on 21.06.2015.
 */
public class Menu extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Manage of Notebook BD");
        Group root = new Group();
        Scene scene = new Scene(root, 520, 600, Color.BISQUE);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
        Button btnAdd = new Button("Add");

        MenuButton btnDelete = new MenuButton("Delete");
        btnDelete.setPopupSide(Side.BOTTOM);
        MenuItem menuItemById = new MenuItem("by ID");
        MenuItem menuItemByModel = new MenuItem("by model");
        btnDelete.getItems().addAll(menuItemById, menuItemByModel);

        MenuButton btnChange = new MenuButton("Change");
        btnChange.setPopupSide(Side.BOTTOM);
        MenuItem menuItemChangePrice = new MenuItem("Price");
        MenuItem menuItemChangeSerialAndVendor = new MenuItem("Serial and Vendor");
        btnChange.getItems().addAll(menuItemChangePrice, menuItemChangeSerialAndVendor);

        MenuButton btnShow = new MenuButton("Show");
        btnShow.setPopupSide(Side.BOTTOM);
        MenuItem menuItemShowByVendor = new MenuItem("By vendor");
        MenuItem menuItemShowAll = new MenuItem("All");
        MenuItem menuItemByPriceAndDate = new MenuItem("By price and manufacture date");
        MenuItem menuItemByPriceRangeAndDate = new MenuItem("By vendor and price range, less than date");
        btnShow.getItems().addAll(menuItemShowByVendor, menuItemByPriceAndDate, menuItemByPriceRangeAndDate, menuItemShowAll);

        /*
        Buttons for action
         */
        Button actionBtnForAdd = new Button("ADD");
        actionBtnForAdd.setPrefSize(100, 20);
        Button actionBtnForDelete = new Button("DELETE");
        actionBtnForDelete.setPrefSize(100,20);
        Button nextPageBtn = new Button("Next");
        nextPageBtn.setPrefSize(60,20);
        Button prevPageBtn = new Button("Prev");
        prevPageBtn.setPrefSize(60,20);
        Button actionBtnForChangePrice = new Button("Change Price");
        Button actionBtnForChangeSerialAndVendor = new Button("Change serial and vendor");
        Button actionBtnForDeleteByModel = new Button("DELETE");
        actionBtnForDeleteByModel.setPrefSize(100,20);
        Button actionBtnForShowByVendor = new Button("Show");
        actionBtnForDeleteByModel.setPrefSize(100,20);
        Button actionBtnForShowByPriceDate = new Button("Show");
        actionBtnForDeleteByModel.setPrefSize(100,20);
        Button actionBtnForShowByPriceRange = new Button("Show");
        actionBtnForDeleteByModel.setPrefSize(100,20);


        TextField idTextFieldForDelete = createTextField(40, 20);
        TextField idTextFieldForChangePrice = createTextField(40, 20);
        TextField idTextFieldForChangeSerialAndVendor = createTextField(40, 20);

        TextField serialTextField = createTextField(100, 20);
        TextField serialTextFieldForChangeSerialAndVendor = createTextField(100, 20);

        TextField vendorTextField = createTextField(80, 20);
        TextField vendorTextFieldForChangeSerialAndVendor = createTextField(80, 20);
        TextField vendorTextFieldForShow = createTextField(80, 20);
        TextField vendorTextFieldForShowByRange = createTextField(80, 20);

        TextField modelTextField = createTextField(80, 20);
        TextField modelTextFieldForDelete = createTextField(80, 20);

        TextField dateTextField = createTextField(60, 20);
        TextField dateTextFieldForShowByPrice = createTextField(80, 20);
        TextField dateTextFieldForShowByPriceRange = createTextField(80, 20);

        TextField priceTextField = createTextField(80, 20);
        TextField priceTextFieldForChangePrice = createTextField(110, 20);
        TextField priceTextFieldForShowByPrice = createTextField(80, 20);
        TextField priceTextFieldForShowByRangeFromPrice = createTextField(100, 20);
        TextField priceTextFieldForShowByRangeToPrice = createTextField(100, 20);

        Label idLbl = new Label("ID");
        Label idLblForDelete = new Label("ID");
        Label idLblForChangePrice = new Label("ID");
        Label idLblForChangeSerAndVendor = new Label("ID");
        Label serialLbl = new Label("Serial number");
        Label serialLblForChangeSerialAndVendor = new Label("New serial number");
        Label vendorLbl = new Label("Vendor");
        Label vendorLblForChangeSerialAndVendor = new Label("New vendor");
        Label vendorLblForSHowByVendor = new Label("Vendor");
        Label vendorLblForShowByRange = new Label("Vendor");
        Label modelLbl = new Label("Model");
        Label modelLblForDelete = new Label("Model for delete");
        Label dateLbl = new Label("Date");
        Label dateLblForShowByPriceAndDate = new Label("Date");
        Label dateLblForShowByPriceRangeLessDate = new Label("Less than Date");
        Label priceLbl = new Label("Price, USD");
        Label priceLblForChangePrice = new Label("New price, USD");
        Label priceLblForShowByPrice = new Label("Price, USD");
        Label priceLblForShowByRangeFromPrice = new Label("From price, USD");
        Label priceLblForShowByRangeToPrice = new Label("To price, USD");

        VBox idVboxForChangePrice = createVBox(idLblForChangePrice, idTextFieldForChangePrice);
        VBox idVboxForDelete = createVBox(idLblForDelete, idTextFieldForDelete);
        VBox idVboxForChangeSerialAndVendor = createVBox(idLblForChangeSerAndVendor, idTextFieldForChangeSerialAndVendor);

        VBox serialVbox = createVBox(serialLbl, serialTextField);
        VBox serialVboxForChangeSerialAndVendor = createVBox(serialLblForChangeSerialAndVendor, serialTextFieldForChangeSerialAndVendor);

        VBox vendorVbox = createVBox(vendorLbl, vendorTextField);
        VBox vendorVboxForChangeSerialAndVendor = createVBox(vendorLblForChangeSerialAndVendor, vendorTextFieldForChangeSerialAndVendor);
        VBox vendorVboxForShowByVendor = createVBox(vendorLblForSHowByVendor, vendorTextFieldForShow);
        VBox vendorVboxForShowByRange = createVBox(vendorLblForShowByRange, vendorTextFieldForShowByRange);

        VBox modelVbox = createVBox(modelLbl, modelTextField);
        VBox modelVboxForDelete = createVBox(modelLblForDelete, modelTextFieldForDelete);

        VBox dateVbox = createVBox(dateLbl, dateTextField);
        VBox dateVboxForShowByPriceAndDate = createVBox(dateLblForShowByPriceAndDate, dateTextFieldForShowByPrice);
        VBox dateVboxForShowByPriceRangeLessDate = createVBox(dateLblForShowByPriceRangeLessDate, dateTextFieldForShowByPriceRange);

        VBox priceVbox = createVBox(priceLbl, priceTextField);
        VBox priceVboxForChangePrice = createVBox(priceLblForChangePrice, priceTextFieldForChangePrice);
        VBox priceVboxForShowByPriceAndDate = createVBox(priceLblForShowByPrice, priceTextFieldForShowByPrice);
        VBox priceVboxForShowByRangeFromPrice = createVBox(priceLblForShowByRangeFromPrice, priceTextFieldForShowByRangeFromPrice);
        VBox priceVboxForShowByRangeToPrice = createVBox(priceLblForShowByRangeToPrice, priceTextFieldForShowByRangeToPrice);

        HBox hBoxBtns = new HBox();
        hBoxBtns.setPadding(new Insets(15, 12, 15, 20));
        hBoxBtns.setSpacing(20);
        hBoxBtns.getChildren().addAll(btnAdd, btnDelete, btnChange, btnShow);

        HBox textFieldsHBox = new HBox();
        textFieldsHBox.setPadding(new Insets(15, 10, 0, 0));
        textFieldsHBox.setSpacing(4);
        textFieldsHBox.getChildren().addAll(serialVbox, vendorVbox,
                modelVbox, dateVbox, priceVbox);

        HBox fildsAndLblsForChangePrice = new HBox();
        fildsAndLblsForChangePrice.setPadding(new Insets(15, 10, 0, 0));
        fildsAndLblsForChangePrice.setSpacing(6);
        fildsAndLblsForChangePrice.getChildren().addAll(idVboxForChangePrice, priceVboxForChangePrice);

        HBox fildsAndLblsForChangeSerialAndVendor = new HBox();
        fildsAndLblsForChangeSerialAndVendor.setPadding(new Insets(15, 10, 0, 0));
        fildsAndLblsForChangeSerialAndVendor.setSpacing(6);
        fildsAndLblsForChangeSerialAndVendor.getChildren().addAll(idVboxForChangeSerialAndVendor, serialVboxForChangeSerialAndVendor,
                vendorVboxForChangeSerialAndVendor);

        HBox fildsAndLblsForShowByPriceAndDate = new HBox();
        fildsAndLblsForShowByPriceAndDate.setPadding(new Insets(15, 10, 0, 0));
        fildsAndLblsForShowByPriceAndDate.setSpacing(6);
        fildsAndLblsForShowByPriceAndDate.getChildren().addAll(priceVboxForShowByPriceAndDate, dateVboxForShowByPriceAndDate);

        HBox fildsAndLblsForShowByPriceRangeLessDate = new HBox();
        fildsAndLblsForShowByPriceRangeLessDate.setPadding(new Insets(15, 10, 0, 0));
        fildsAndLblsForShowByPriceRangeLessDate.setSpacing(6);
        fildsAndLblsForShowByPriceRangeLessDate.getChildren().addAll(priceVboxForShowByRangeFromPrice, priceVboxForShowByRangeToPrice,
                dateVboxForShowByPriceRangeLessDate, vendorVboxForShowByRange);

        VBox changePriceVboxFinal = createVBox(fildsAndLblsForChangePrice, actionBtnForChangePrice);
        changePriceVboxFinal.setPadding(new Insets(0, 0, 0, 20));
        changePriceVboxFinal.setAlignment(Pos.BASELINE_LEFT);

        VBox changeSerialAndVendorFinal = createVBox(fildsAndLblsForChangeSerialAndVendor, actionBtnForChangeSerialAndVendor);
        changeSerialAndVendorFinal.setPadding(new Insets(0, 0, 0, 20));
        changeSerialAndVendorFinal.setAlignment(Pos.BASELINE_LEFT);

        VBox showByPriceAndDateFinal = createVBox(fildsAndLblsForShowByPriceAndDate, actionBtnForShowByPriceDate);
        showByPriceAndDateFinal.setPadding(new Insets(0, 0, 0, 20));
        showByPriceAndDateFinal.setAlignment(Pos.BASELINE_LEFT);

        VBox showByPriceRangeLessDateFinal = createVBox(fildsAndLblsForShowByPriceRangeLessDate, actionBtnForShowByPriceRange);
        showByPriceRangeLessDateFinal.setPadding(new Insets(0, 0, 0, 20));
        showByPriceRangeLessDateFinal.setAlignment(Pos.BASELINE_LEFT);

        VBox addBox = createVBox(textFieldsHBox, actionBtnForAdd);
        addBox.setPadding(new Insets(0,0,0,20));
        addBox.setAlignment(Pos.BASELINE_LEFT);

        VBox byIdBox = createVBox(idVboxForDelete, actionBtnForDelete);
        byIdBox.setPadding(new Insets(20, 0, 0, 20));
        byIdBox.setAlignment(Pos.BOTTOM_LEFT);

        VBox byModelVbox = createVBox(modelVboxForDelete, actionBtnForDeleteByModel);
        byModelVbox.setPadding(new Insets(20, 0, 0, 20));
        byModelVbox.setAlignment(Pos.BOTTOM_LEFT);

        VBox showByVendorVboxFinal = createVBox(vendorVboxForShowByVendor, actionBtnForShowByVendor);
        showByVendorVboxFinal.setPadding(new Insets(20, 0, 0, 20));
        showByVendorVboxFinal.setAlignment(Pos.BOTTOM_LEFT);

        BorderPane border = new BorderPane();
        border.setTop(hBoxBtns);
        root.getChildren().add(border);

        btnAdd.setOnAction(e -> {
            border.setCenter(addBox);
        });

        menuItemById.setOnAction(event -> {
            border.setCenter(byIdBox);
        });

        menuItemChangePrice.setOnAction(event -> border.setCenter(changePriceVboxFinal));

        menuItemChangeSerialAndVendor.setOnAction(e -> border.setCenter(changeSerialAndVendorFinal));

        menuItemByModel.setOnAction(e -> border.setCenter(byModelVbox));

        menuItemShowByVendor.setOnAction(e -> border.setCenter(showByVendorVboxFinal));
        menuItemByPriceAndDate.setOnAction(e -> border.setCenter(showByPriceAndDateFinal));
        menuItemByPriceRangeAndDate.setOnAction(e -> border.setCenter(showByPriceRangeLessDateFinal));

        menuItemShowAll.setOnAction(event -> {
            NotebookServiceImpl notebookService = new NotebookServiceImpl();
            List<Notebook> list = notebookService.findAll();
            TableView<Notebook> table = createTable(list);

            VBox tableVbox = createVBox(table, nextPageBtn);
            tableVbox.setPadding(new Insets(35, 3, 3, 20));
            border.setCenter(tableVbox);
        });

        actionBtnForAdd.setOnAction(event -> {

            String serial = serialTextField.getText();
            String vendor = vendorTextField.getText();
            String model = modelTextField.getText();
            String date = dateTextField.getText();
            String price = priceTextField.getText();
            if(serial.equalsIgnoreCase("") || vendor.equalsIgnoreCase("") || model.equalsIgnoreCase("")
                    || date.equalsIgnoreCase("") || price.equalsIgnoreCase("")) {
                AlertBox alert = new AlertBox();
                alert.displayAlert("WARNING", "Empty fields are unacceptable");
            } else {
                serialTextField.clear();
                vendorTextField.clear();
                modelTextField.clear();
                dateTextField.clear();
                priceTextField.clear();
                try {
                    Notebook notebook = new Notebook(serial, vendor,
                            model, date, Double.parseDouble(price));
                    NotebookServiceImpl notebookService = new NotebookServiceImpl();
                    notebookService.add(notebook);
                } catch (ParseException ex) {
                    AlertBox alert = new AlertBox();
                    alert.displayAlert("WARNING", "Wrong date format");
                }
            }
        });

        actionBtnForDelete.setOnAction(event -> {
            String id = idTextFieldForDelete.getText();
            idTextFieldForDelete.clear();
            if(id.equals("")) {
                AlertBox alert = new AlertBox();
                alert.displayAlert("WARNING", "Empty fields are unacceptable");
            } else {
                NotebookServiceImpl notebookService = new NotebookServiceImpl();
                notebookService.delete(Long.parseLong(id));
            }
        });

        actionBtnForChangePrice.setOnAction(event -> {
            String id = idTextFieldForChangePrice.getText();
            String price = priceTextFieldForChangePrice.getText();
            idTextFieldForChangePrice.clear();
            priceTextFieldForChangePrice.clear();
            if(id.equals("") || price.equals("")) {
                AlertBox alert = new AlertBox();
                alert.displayAlert("WARNING", "Empty fields are unacceptable");
            } else {
                NotebookServiceImpl notebookService = new NotebookServiceImpl();
                notebookService.changePrice(Long.parseLong(id), Double.parseDouble(price));
            }
        });

        actionBtnForChangeSerialAndVendor.setOnAction(event -> {
            String id = idTextFieldForChangeSerialAndVendor.getText();
            String serial = serialTextFieldForChangeSerialAndVendor.getText();
            String vendor = vendorTextFieldForChangeSerialAndVendor.getText();
            idTextFieldForChangeSerialAndVendor.clear();
            serialTextFieldForChangeSerialAndVendor.clear();
            vendorTextFieldForChangeSerialAndVendor.clear();
            if(id.equals("") || serial.equals("") || vendor.equals("")) {
                AlertBox alert = new AlertBox();
                alert.displayAlert("WARNING", "Empty fields are unacceptable");
            } else {
                NotebookServiceImpl notebookService = new NotebookServiceImpl();
                notebookService.changeSerialVendor(Long.parseLong(id), serial, vendor);
            }
        });

        actionBtnForDeleteByModel.setOnAction(event -> {
            String model = modelTextFieldForDelete.getText();
            idTextFieldForDelete.clear();
            if(model.equals("")) {
                AlertBox alert = new AlertBox();
                alert.displayAlert("WARNING", "Empty fields are unacceptable");
            } else {
                NotebookServiceImpl notebookService = new NotebookServiceImpl();
                notebookService.deleteByModel(model);
            }
        });

        actionBtnForShowByVendor.setOnAction(event -> {
            String vendor = vendorTextFieldForShow.getText();
            idTextFieldForDelete.clear();
            if(vendor.equals("")) {
                AlertBox alert = new AlertBox();
                alert.displayAlert("WARNING", "Empty fields are unacceptable");
            } else {
                NotebookServiceImpl notebookService = new NotebookServiceImpl();
                List<Notebook> list = notebookService.findByVendor(vendor);

                TableView<Notebook> table = createTable(list);

                VBox tableVbox = createVBox(table, nextPageBtn);
                tableVbox.setPadding(new Insets(35, 12, 12, 20));
                border.setCenter(tableVbox);
            }
        });

        actionBtnForShowByPriceDate.setOnAction(event -> {
            String date = dateTextFieldForShowByPrice.getText();
            String price = priceTextFieldForShowByPrice.getText();
            idTextFieldForChangePrice.clear();
            priceTextFieldForChangePrice.clear();
            if(date.equals("") || price.equals("")) {
                AlertBox alert = new AlertBox();
                alert.displayAlert("WARNING", "Empty fields are unacceptable");
            } else {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    Date dt = sdf.parse(date);
                    NotebookServiceImpl notebookService = new NotebookServiceImpl();
                    List<Notebook> list = notebookService.findByPriceManufDate(Double.parseDouble(price), dt);

                    TableView<Notebook> table = createTable(list);

                    VBox tableVbox = createVBox(table, nextPageBtn);
                    tableVbox.setPadding(new Insets(35, 12, 12, 20));
                    border.setCenter(tableVbox);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    AlertBox alert = new AlertBox();
                    alert.displayAlert("WARNING", "Wrong date format");
                }
            }
        });

        actionBtnForShowByPriceRange.setOnAction(event -> {
            String priceFrom = priceTextFieldForShowByRangeFromPrice.getText();
            String priceTo = priceTextFieldForShowByRangeToPrice.getText();
            String date = dateTextFieldForShowByPriceRange.getText();
            String vendor = vendorTextFieldForShowByRange.getText();
            priceTextFieldForShowByRangeFromPrice.clear();
            priceTextFieldForShowByRangeToPrice.clear();
            dateTextFieldForShowByPriceRange.clear();
            vendorTextFieldForShowByRange.clear();
            if(priceFrom.equals("") || priceTo.equals("") || date.equals("") || vendor.equals("")) {
                AlertBox alert = new AlertBox();
                alert.displayAlert("WARNING", "Empty fields are unacceptable");
            } else {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    Date dt = sdf.parse(date);
                    NotebookServiceImpl notebookService = new NotebookServiceImpl();
                    List <Notebook> list = notebookService.findBetweenPriceLtDateByVendor(Double.parseDouble(priceFrom),
                            Double.parseDouble(priceTo), dt, vendor);

                    TableView<Notebook> table = createTable(list);

                    VBox tableVbox = createVBox(table, nextPageBtn);
                    tableVbox.setPadding(new Insets(35, 0, 0, 20));
                    border.setCenter(tableVbox);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    AlertBox alert = new AlertBox();
                    alert.displayAlert("WARNING", "Wrong date format");
                }

            }
        });

    }



    private TextField createTextField(double width, double height) {
        TextField result = new TextField();
        result.setPrefSize(width, height);
        return result;
    }

    private VBox createVBox(Node nodeOne, Node nodeTwo) {
        VBox result = new VBox();
        result.setAlignment(Pos.CENTER);
        result.setSpacing(2);
        result.setPadding(new Insets(10, 0, 15, 0));
        result.getChildren().addAll(nodeOne, nodeTwo);
        return result;
    }

    private TableView<Notebook> createTable(List<Notebook> list) {
        ObservableList<Notebook> notebooks = FXCollections.observableArrayList();
        for(Notebook ntb : list) {
            notebooks.add(ntb);
        }
        TableView<Notebook> table = new TableView<>();
        table.setTableMenuButtonVisible(true);
        table.setPrefWidth(480);
        table.setPrefHeight(450);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("id"));
        idCol.setPrefWidth(30);
        idCol.setResizable(false);
        idCol.setSortable(true);

        TableColumn serialCol = new TableColumn("Serial");
        serialCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("serial"));
        serialCol.setPrefWidth(140);
        serialCol.setResizable(true);


        TableColumn vendorCol = new TableColumn("Vendor");
        vendorCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("vendor"));

        TableColumn modelCol = new TableColumn("Model");
        modelCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("model"));

        TableColumn dateCol = new TableColumn("Manufacture date");
        dateCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("manufactureDate"));

        TableColumn priceCol = new TableColumn("Price");
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("price"));

        table.setItems(notebooks);
        table.getColumns().addAll(idCol, serialCol, vendorCol, modelCol, dateCol, priceCol);
        return table;
    }

    public void deleteNtb(Notebook notebook) {
        NotebookDaoImpl dao = new NotebookDaoImpl(HibernateUtil.getSessionFactory());
        dao.delete(notebook);
    }
    public void changePrice(Notebook notebook) {
        NotebookDaoImpl dao = new NotebookDaoImpl(HibernateUtil.getSessionFactory());
        dao.update(notebook);
    }
    public void changeSerialVendor(Notebook notebook) {
        NotebookDaoImpl dao = new NotebookDaoImpl(HibernateUtil.getSessionFactory());
        dao.update(notebook);
    }

    public void deleteByModel() {}
    public void showByVendor() {}
    public void showByPriceManufDate() {}
    public void showBetweenPriceLtDateByVendor(){}
}

class AlertBox {

    public static  void displayAlert(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(80);
        Label label = new Label(message);
        Button okBtn = new Button("OK");
        okBtn.setPrefSize(40, 20);
        okBtn.setOnAction(event -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, okBtn);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}


