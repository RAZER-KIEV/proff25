package hw5.auth;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by GFalcon on 10.06.15.
 Ќаписать приложение выполн€ющее аутентификацию пользовател€
 на основе учЄтной записи созданнной в предыдущем задании.
 ≈сли пользователь зарегистрирован, то выводим список
 зарегистрированных пользователей, если нет, выводим "Ќеправильный логин или пароль"

 public int create(User user)
 public List<User> findAll()
 public User readByNamePass(String login, String pass)

  лассы задани€:
 hw5.auth.MainWindow
 hw5.auth.UserJDBCManager
 hw5.auth.User
 */

public class MainWindow extends Application{
    private Label lblConnectStatus;
    private TextArea txtUsers;
    private Button btnGetList;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage mainWindow = new Stage();
        mainWindow.setTitle("Users DB");
        mainWindow.setScene(mainScene());
        mainWindow.show();

    }

    public Scene mainScene (){
        BorderPane mainPane = new BorderPane();

        Button btnConnect = new Button("Connect");
        Button btnDisconnect = new Button("Disconnect");
        lblConnectStatus = new Label();
     //   mainPane.setTop(new HBox(btnConnect, btnDisconnect));
        mainPane.setCenter(paneAddUser());
        mainPane.setBottom(lblConnectStatus);

        btnConnect.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lblConnectStatus.setText("Set connecting...");

                lblConnectStatus.setText("Connection is established");
            }
        });

        btnDisconnect.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lblConnectStatus.setText("Connecting closed");
            }
        });

        return new Scene(mainPane, 600, 400);
    }

    public BorderPane paneAddUser(){
        TextField txtUserID = new TextField();
        TextField txtUserName = new TextField();
        TextField txtPassword = new TextField();
        HBox hBox = new HBox();
      //  hBox.getChildren().add(new Label("ID "));
       // hBox.getChildren().add(txtUserID);
        hBox.getChildren().add(new Label("User name: "));
        hBox.getChildren().add(txtUserName);
        hBox.getChildren().add(new Label(" Password "));
        hBox.getChildren().add(txtPassword);
        Button btnAddUser = new Button("Add new User to Base");
        hBox.getChildren().add(btnAddUser);
        Button btnLogin = new Button("Login");
        hBox.getChildren().add(btnLogin);

        btnAddUser.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               // addNewUserToBase(txtUserID.getText(), txtUserName.getText(), txtPassword.getText());
                addNewUserToBase(txtUserName.getText(), txtPassword.getText());
            }
        });

        btnLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                login(txtUserName.getText(), txtPassword.getText());
            }
        });

        return new BorderPane(paneUsersList(), hBox, null, null, null);
    }

    public BorderPane paneUsersList(){
        btnGetList = new Button("View Users list");
        btnGetList.setVisible(false);
        txtUsers = new TextArea();
        btnGetList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                getAllUsersList();
            }
        });

        return new BorderPane(txtUsers,null,null,btnGetList,null);
    }

    public void addNewUserToBase(String id, String name, String pass){
        // This method should add a new user into the table.
        User user = new User(id, name, pass);
        UserJDBCManager dbManeger = null;
        try {
            dbManeger = new UserJDBCManager();
            dbManeger.create(user);
            lblConnectStatus.setText("Created 1 user");
            dbManeger.close();
        } catch (SQLException eException) {
            String errMassage = eException.getMessage();
            lblConnectStatus.setText(errMassage);
            try {
                dbManeger.close();
            } catch (SQLException e1Exception) {
                errMassage = e1Exception.getMessage();
                lblConnectStatus.setText(errMassage);
            }
            System.out.println(errMassage);
        }
    }
    public void addNewUserToBase(String name, String pass){
        // This method should add a new user into the table.
        User user = new User(name, pass);
        UserJDBCManager dbManeger = null;
        try {
            dbManeger = new UserJDBCManager();
            dbManeger.create(user);
            getAllUsersList();
            lblConnectStatus.setText("Created 1 user");
            dbManeger.close();
        } catch (SQLException eException) {
            String errMassage = eException.getMessage();
            lblConnectStatus.setText(errMassage);
            try {
                dbManeger.close();
            } catch (SQLException e1Exception) {
                errMassage = e1Exception.getMessage();
                lblConnectStatus.setText(errMassage);
            }
            System.out.println(errMassage);
        }

    }
    public void getAllUsersList(){
        // this method set connecting to DataBese
        List<User> list;
        UserJDBCManager dbManeger = null;
        txtUsers.clear();

        try{
            dbManeger = new UserJDBCManager();
            list = dbManeger.findAll();
            dbManeger.close();
            int iter;
            for (iter = 0; iter < list.size(); iter++){
                //new User(list.get(i).getUserId(), list.get(i).getName(), list.get(i).getPass(), list.get(i).getRegistrationDate());
                txtUsers.appendText("ID: " + list.get(iter).getUserId() + "\t User name: " + list.get(iter).getName() + "\t password: " +  list.get(iter).getPass() + "\t Reg.date: " +  list.get(iter).getRegistrationDate() + "\n");
            }
            lblConnectStatus.setText("Read " + iter + " rows from database");

        } catch (SQLException eException){
            String errMassage = eException.getMessage();
            lblConnectStatus.setText(errMassage);
            try {
                dbManeger.close();
            } catch (SQLException e1Exception) {
                errMassage = e1Exception.getMessage();
                lblConnectStatus.setText(errMassage);
            }
            System.out.println(errMassage);
        }
    }

    public void login(String login, String pass){
        UserJDBCManager dbm = null;
        try {
            dbm = new UserJDBCManager();
            try {
                if(!dbm.readByNamePass(login, pass).equals(null)){
                    getAllUsersList();
                    btnGetList.setVisible(true);
                }
            } catch (NullPointerException elUs) {
                lblConnectStatus.setText("Ќеправильный логин или пароль");
            }
        } catch (Exception el) {
            lblConnectStatus.setText(el.getMessage());
            try {
                dbm.close();
            } catch (SQLException elm) {
                lblConnectStatus.setText(elm.getMessage());
            }
        }
    }
}
