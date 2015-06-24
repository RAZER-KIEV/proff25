package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ПК on 18.06.2015.
 */
public class Menu extends Application implements EventHandler {
    private static HibernateUtil hibernateUtil;
    private static SessionFactory sessionFactory;
    private static NotebookDaoImpl notebookDao;
    private static NotebookServiceImpl notebookService;

    private ObservableList<String> messeges = FXCollections.observableArrayList("App Launched");

    private ObservableList<Notebook> olNotebooks = FXCollections.observableArrayList();

    private TextField tfDateSet,tfIdSet,tfSetPriceTo,tfSetPriceFrom,tfSetMess;


    public static void main(String[] args) {Application.launch();}

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Notebooks Manage");

        Group root = new Group();
        Scene scene = new Scene(root, 525, 680, Color.GREENYELLOW);
        stage.setScene(scene);

        final DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(10);
        dropShadow.setOffsetY(10);


        Button btnShowTable = new Button("Show Table");
        btnShowTable.setOnAction(this);
        btnShowTable.setPrefSize(150, 30);
        btnShowTable.setLayoutX(10);
        btnShowTable.setLayoutY(10);
        btnShowTable.setEffect(dropShadow);
        root.getChildren().add(btnShowTable);

        Button btnDeleteAll = new Button("Delete All");
        btnDeleteAll.setOnAction(this);
        btnDeleteAll.setPrefSize(150, 30);
        btnDeleteAll.setLayoutX(170);
        btnDeleteAll.setLayoutY(10);
        btnDeleteAll.setEffect(dropShadow);
        root.getChildren().add(btnDeleteAll);


        Button btnShowbyVendor= new Button("Show by Vendor");
        btnShowbyVendor.setOnAction(this);
        btnShowbyVendor.setPrefSize(150, 30);
        btnShowbyVendor.setLayoutX(10);
        btnShowbyVendor.setLayoutY(510);
        btnShowbyVendor.setEffect(dropShadow);
        root.getChildren().add(btnShowbyVendor);




        Button btnShowByModel= new Button("Show by Model");
        btnShowByModel.setOnAction(this);
        btnShowByModel.setPrefSize(150, 30);
        btnShowByModel.setLayoutX(170);
        btnShowByModel.setLayoutY(510);
        btnShowByModel.setEffect(dropShadow);
        root.getChildren().add(btnShowByModel);


        Button findBetweenPriceLtDateByVendor= new Button("Btwn Prc, LtDate, Vendor");
        findBetweenPriceLtDateByVendor.setOnAction(this);
        findBetweenPriceLtDateByVendor.setPrefSize(200, 30);
        findBetweenPriceLtDateByVendor.setLayoutX(310);
        findBetweenPriceLtDateByVendor.setLayoutY(600);
        findBetweenPriceLtDateByVendor.setEffect(dropShadow);
        root.getChildren().add(findBetweenPriceLtDateByVendor);

        Button deleteById = new Button("delete By Id");
        deleteById.setOnAction(this);
        deleteById.setPrefSize(100, 30);
        deleteById.setLayoutX(10);
        deleteById.setLayoutY(600);
        deleteById.setEffect(dropShadow);
        root.getChildren().add(deleteById);

       Button addNotebook = new Button("add Notebook");
        addNotebook.setOnAction(this);
        addNotebook.setPrefSize(100, 30);
        addNotebook.setLayoutX(120);
        addNotebook.setLayoutY(600);
        addNotebook.setEffect(dropShadow);
        root.getChildren().add(addNotebook);



        Button findByPriceManufDate= new Button("Show by Price and Manuf.Date");
        findByPriceManufDate.setOnAction(this);
        findByPriceManufDate.setPrefSize(180, 30);
        findByPriceManufDate.setLayoutX(330);
        findByPriceManufDate.setLayoutY(510);
        findByPriceManufDate.setEffect(dropShadow);
        root.getChildren().add(findByPriceManufDate);

        Button btnFTbRand = new Button("Fill the Table by Random");
        btnFTbRand.setOnAction(this);
        btnFTbRand.setPrefSize(150, 30);
        btnFTbRand.setLayoutX(360);
        btnFTbRand.setLayoutY(10);
        btnFTbRand.setEffect(dropShadow);
        root.getChildren().add(btnFTbRand);


        BorderPane pane = new BorderPane();
        pane.setLayoutX(10);
        pane.setLayoutY(50);

        TableColumn vendorCol = new TableColumn("VENDOR");
        vendorCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("vendor"));

        TableColumn modelCol = new TableColumn("MODEL");
        modelCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("model"));

        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("id"));


        TableColumn serialCol = new TableColumn("SERIAL");
        serialCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, String>("serial"));

        TableColumn manufacture_dateCol = new TableColumn("manufacture_date");
        manufacture_dateCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, Date>("manufacture_date"));

        TableColumn priceCol = new TableColumn("price");
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Notebook, Double>("price"));


        TableView<Notebook> table = new TableView<>(olNotebooks);
        table.setEffect(dropShadow);
        table.setVisible(true);
        table.setPrefSize(500, 400);
        table.setLayoutX(10);
        table.setLayoutY(50);
        table.getColumns().addAll(idCol, vendorCol, modelCol, serialCol, priceCol, manufacture_dateCol);
        table.setItems(olNotebooks);
        pane.setCenter(table);
        root.getChildren().add(pane);

        tfSetMess = new TextField();
        tfSetMess.setPrefSize(500, 35);
        tfSetMess.setLayoutX(10);
        tfSetMess.setLayoutY(465);
        tfSetMess.setPromptText("Add Notebook:\"Vendor,model,serial,price,2015.12.31\" OR VENDOR OR MODEL");
        tfSetMess.setEditable(true);
        tfSetMess.setEffect(dropShadow);
        root.getChildren().add(tfSetMess);

        tfSetPriceFrom = new TextField();
        tfSetPriceFrom.setPrefSize(100, 35);
        tfSetPriceFrom.setLayoutX(10);
        tfSetPriceFrom.setLayoutY(550);
        tfSetPriceFrom.setPromptText("Price from");
        tfSetPriceFrom.setEditable(true);
        tfSetPriceFrom.setEffect(dropShadow);
        root.getChildren().add(tfSetPriceFrom);


        tfSetPriceTo = new TextField();
        tfSetPriceTo.setPrefSize(100, 35);
        tfSetPriceTo.setLayoutX(130);
        tfSetPriceTo.setLayoutY(550);
        tfSetPriceTo.setPromptText("Price to");
        tfSetPriceTo.setEditable(true);
        tfSetPriceTo.setEffect(dropShadow);
        root.getChildren().add(tfSetPriceTo);

        tfDateSet = new TextField();
        tfDateSet.setPrefSize(200, 35);
        tfDateSet.setLayoutX(250);
        tfDateSet.setLayoutY(550);
        tfDateSet.setPromptText("Set date Like \"2015.12.31\" ");
        tfDateSet.setEditable(true);
        tfDateSet.setEffect(dropShadow);
        root.getChildren().add(tfDateSet);

        tfIdSet = new TextField();
        tfIdSet.setPrefSize(50, 35);
        tfIdSet.setLayoutX(460);
        tfIdSet.setLayoutY(550);
        tfIdSet.setPromptText("Set ID");
        tfIdSet.setEditable(true);
        tfIdSet.setEffect(dropShadow);
        root.getChildren().add(tfIdSet);







       /* Button btnSend = new Button("Send!");
        btnSend.setOnAction(this);
        btnSend.setPrefSize(80, 80);
        btnSend.setLayoutX(425);
        btnSend.setLayoutY(465);
        btnSend.setEffect(dropShadow);
        root.getChildren().add(btnSend); */


        stage.show();





    }

    @Override
    public void handle(Event event) {
        String name = ((Button) (event.getSource())).getText();
        System.out.println(name);
        List<Notebook> reslist = null;
        String sDate;
        String [] splited, dateSplit;
        Date date;
        Double sPriseTo,sPriseFrom;
        String vendor;
        Long lID;


        switch (name) {
            case "Fill the Table by Random":
                fillTheTable(100);

                break;
            case "Show Table":
                olNotebooks.clear();
                reslist = notebookDao.findAll();
                for (Notebook ntb:reslist){
                    messeges.add(ntb.toString());
                    olNotebooks.add(ntb);
                }

                break;
            case  "Show by Vendor":
                olNotebooks.clear();
                reslist = notebookDao.findByVendor(tfSetMess.getText());
                for (Notebook ntb:reslist){
                    messeges.add(ntb.toString());
                    olNotebooks.add(ntb);
                }
                break;
            case  "Show by Model":
                olNotebooks.clear();
                reslist = notebookDao.findByModel(tfSetMess.getText());
                for (Notebook ntb:reslist){
                    messeges.add(ntb.toString());
                    olNotebooks.add(ntb);
                }
                break;
            case "Show by Price and Manuf.Date":
                olNotebooks.clear();
                sDate = tfDateSet.getText();
                splited = sDate.split(".");
                System.out.println(splited);

                date = notebookDao.dateSet(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]), Integer.parseInt(splited[2]));
                System.out.println(date);
                sPriseTo = Double.parseDouble(tfSetPriceTo.getText());
                reslist = notebookDao.findByPriceManufDate(sPriseTo,date);
                for (Notebook ntb:reslist){
                    olNotebooks.add(ntb);
                }
                break;
            case "Delete All":
                olNotebooks.clear();
                notebookDao.deleteAll();
                break;
            case "Btwn Prc, LtDate, Vendor":
                olNotebooks.clear();
                sDate = tfDateSet.getText();
                splited = sDate.split(".");
                System.out.println(splited);
                vendor = tfSetMess.getText();

                date = notebookDao.dateSet(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]), Integer.parseInt(splited[2]));
                System.out.println(date);
                sPriseTo = Double.parseDouble(tfSetPriceTo.getText());
                sPriseFrom = Double.parseDouble(tfSetPriceFrom.getText());
                reslist = notebookDao.findBetweenPriceLtDateByVendor(sPriseFrom, sPriseTo, date, vendor);
                for (Notebook ntb:reslist){
                    olNotebooks.add(ntb);
                }
                break;
            case "delete By Id":
                lID = Long.parseLong(tfIdSet.getText());
                notebookService.delete(lID);
                break;
            case "add Notebook":
                splited = tfSetMess.getText().split(",");
                //for(String s:)

                 dateSplit =  splited[3].split(".");
                date = notebookDao.dateSet(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
                Notebook ntb = new Notebook(splited[2],splited[0],splited[1],date,Double.parseDouble(splited[4]));
                notebookDao.create(ntb);
                notebookService.add(ntb);
                break;
        }
    }



    public void init(){
        Locale.setDefault(Locale.ENGLISH);
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = hibernateUtil.connectToHib();
        notebookDao = new NotebookDaoImpl(sessionFactory);
        notebookService = new NotebookServiceImpl(sessionFactory,notebookDao);
    }


    private Date getRandomDate(){
        Calendar cal = Calendar.getInstance();
        cal.set((int)(Math.random()*5+2010), (int)(Math.random()*11),(int)(Math.random()*31));
        Date date = cal.getTime();
        return date;
    }
    private String getRandomVendor(){
        String[] vendormass = {"Lenovo","Dell","Apple","Asus","HP","Sony","Acer","MSI","Toshba","fujitsu","Panasonic","Samsung","Gigabyte"};
        return vendormass[(int)(Math.random()*vendormass.length)];
    }
    private Double getRandomPrice(){
        Double price = (Double) (Math.random()*1000+400);
        return price;
    }
    private String getRandomModel(){
        String model[] = {"INSPIRON","AIR","Transformer","Extensa", "Vostro","Aspire"};
        return model[(int)(Math.random()*model.length)];
    }
    private String getRandomSerial(){
        int iserial = (int)(Math.random()*999999999+100000000);
        String serial = ""+iserial;
        return serial;
    }

    private void fillTheTable(int quantity){
        int count=0;
        for(int i=0;i<quantity;i++) {
            Notebook notebook = new Notebook(getRandomSerial(), getRandomVendor(), getRandomModel(), getRandomDate(), getRandomPrice());
            notebookDao.create(notebook);
            System.out.println(notebook);
            count++;
        }
        System.out.println("Added "+count+" Notebooks!");
    }


    void deleteNtb(Notebook notebook) {
        notebookDao.delete(notebook);

    }

    void changePrice(Notebook notebook) {
        notebookDao.update(notebook);
    }

    void changeSerialVendor(Notebook notebook) {
        notebookService.changeSerialVendor(notebook.getId(), notebook.getSerial(), notebook.getVendor());

    }

    void deleteByModel() {
        System.out.println("Enter model name to delete by model: ");
        Scanner scanner = new Scanner(System.in);
        String model = scanner.nextLine();
        System.out.println("NoteBook(s) deleted: "+notebookService.deleteByModel(model));
    }

    void showByVendor() {
        System.out.println("Enter vendor name to show by vendor: ");
        Scanner scanner = new Scanner(System.in);
        String vendor = scanner.nextLine();
        List<Notebook> resList = notebookService.findByVendor(vendor);
        System.out.println("Filters: "+vendor);
        for (Notebook ntb:resList){
            System.out.println(ntb);
        }
    }

    void showByPriceManufDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To show \"by Price Manuf Date\" enter price: ");
        Double price = scanner.nextDouble();
        System.out.println("Enter Manuf.Date");
        Date date = notebookDao.dateSet();
        List<Notebook> resList = notebookService.findByPriceManufDate(price, date);
        System.out.println("Filters: price less then "+price+" and manufactored later then "+date+" .");
        for (Notebook ntb:resList){
            System.out.println(ntb);
        }

    }

    void showBetweenPriceLtDateByVendor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To show \"Between Price LtDate By Vendor\" enter price Form: ");
        Double priceFrom = scanner.nextDouble();
        System.out.println("enter priceTo: ");
        Double priceTo = scanner.nextDouble();
        System.out.println("Enter Manuf. date:");
        Date date = notebookDao.dateSet();
        System.out.println("enter vendor: ");
        String vendor = scanner.nextLine();
        List<Notebook> resList = notebookService.findBetweenPriceLtDateByVendor(priceFrom,priceTo,date,vendor);
        System.out.println("Filters: price between "+priceFrom+" and "+priceTo+".  manufactored later then "+date+" vendor is: "+vendor+".");
        for(Notebook ntb:resList){
            System.out.println(ntb);
        }
    }
}
