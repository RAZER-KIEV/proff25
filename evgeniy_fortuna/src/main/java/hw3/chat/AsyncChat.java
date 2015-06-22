package hw3.chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class AsyncChat extends Application {


    private String ip;
    private int port;
    private String message;
    ServerClass serv;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX chat");

        primaryStage.show();
        GridPane grid =new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10d);
        grid.setVgap(10d);
        grid.setPadding(new Insets(5, 25,250,5));

        Scene scene = new Scene(grid, 600, 375);
        primaryStage.setScene(scene);

        Label useAddress = new Label("ADDRESS:");
        grid.add(useAddress, 0, 1);


        TextField addressTextField = new TextField();
        addressTextField.setPromptText("IP-address example: 127.0.0.1");
        grid.add(addressTextField,1,1);

        Label por = new Label("port: ");
        grid.add(por,0,2);

        TextField porBoxTextField = new TextField();
        porBoxTextField.setPromptText("example: 30000 ");
        grid.add(porBoxTextField, 1, 2);

        Button btnConnect = new Button ("CONNECT");

        HBox hbBut = new HBox (5);
        hbBut.setAlignment(Pos.BOTTOM_RIGHT);
        hbBut.getChildren().add(btnConnect);
        grid.add(hbBut,1, 4);
        btnConnect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setIp(addressTextField.getText());
                setPort(Integer.parseInt(porBoxTextField.getText()));
            }
        });
        TextArea area = new TextArea();
        area.setMinSize(400, 200);
        grid.add(area, 1, 5);

        TextField areaSend =  new TextField();
        grid.add(areaSend, 1, 6);

        Button send = new Button("SEND");
        grid.add(send, 0, 6);

        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setMessage(areaSend.getText());
                area.appendText(message +"\n");
            }
        });
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIp() {

        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getMessage() {
        return message;
    }

    public void process(){
        Thread server = new Thread (new ServerClass());
        Thread client = new Thread (new ClientClass());
        server.start();
        client.start();
    }
}

