package hw3.chat;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


/**
 * Created by ПК on 05.06.2015.
 */
public class AsyncChat extends Application implements EventHandler {

    private ObservableList<String> messeges = FXCollections.observableArrayList("Привет!", "халоу", "как оно?");
    private TextField tfPort;
    private TextField tfIpAdress;
    private SocketAddress localIP;
    private SocketAddress remoteIP;
    private boolean isConnected = false;
    private SocketChannel socketChannel;
    private ByteBuffer byteBuffer;
    private TextField tfSetMess;

    public static void main(String[] args) throws IOException {
        Application.launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Let's Chatting!");

        Group root = new Group();
        Scene scene = new Scene(root, 525, 565, Color.GREENYELLOW);
        stage.setScene(scene);

        final DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(10);
        dropShadow.setOffsetY(10);

        tfIpAdress = new TextField("127.0.0.1");

        tfIpAdress.setPrefSize(200, 30);
        tfIpAdress.setEditable(true);
        tfIpAdress.setEffect(dropShadow);

        tfPort = new TextField("30056");
        tfPort.setPrefSize(140, 30);
        tfPort.setEditable(true);
        tfPort.setEffect(dropShadow);


        Button btnConnect = new Button("Connect");
        btnConnect.setOnAction(this);
        btnConnect.setPrefSize(120, 30);
        btnConnect.setLayoutX(390);
        btnConnect.setLayoutY(10);
        btnConnect.setEffect(dropShadow);
        // btnConnect.setStyle("-fx-background-color:#66ccff;");


        HBox hBox = new HBox(15);
        hBox.setLayoutX(10);
        hBox.setLayoutY(10);
        hBox.getChildren().addAll(tfIpAdress, tfPort, btnConnect);
        root.getChildren().add(hBox);

        root.getChildren().add(btnConnect);


        BorderPane pane = new BorderPane();
        pane.setLayoutX(10);
        pane.setLayoutY(50);


        messeges = FXCollections.observableArrayList(
                "Привет!", "халоу", "как оно?");

        ListView<String> mainJournal = new ListView<String>(messeges);
        mainJournal.setOrientation(Orientation.VERTICAL);
        mainJournal.setEffect(dropShadow);
        mainJournal.setVisible(true);
        mainJournal.setPrefSize(500, 400);
        mainJournal.setLayoutX(10);
        mainJournal.setLayoutY(50);

        pane.setCenter(mainJournal);
        root.getChildren().add(pane);


        tfSetMess = new TextField("send Hello!");
        tfSetMess.setPrefSize(400, 80);
        tfSetMess.setLayoutX(10);
        tfSetMess.setLayoutY(465);
        tfSetMess.setEditable(true);
        tfSetMess.setEffect(dropShadow);
        root.getChildren().add(tfSetMess);

        Button btnSend = new Button("Send!");
        btnSend.setOnAction(this);
        btnSend.setPrefSize(80, 80);
        btnSend.setLayoutX(425);
        btnSend.setLayoutY(465);
        btnSend.setEffect(dropShadow);
        root.getChildren().add(btnSend);


        stage.show();


        class Server extends Thread {
            public void run() {
                try {
                    //StringBuilder sb = new StringBuilder();
                    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                    int randomPort = (int) (Math.random() * 30000 + 30000);
                    serverSocketChannel.socket().bind(new InetSocketAddress(randomPort));
                    messeges.add(String.valueOf(randomPort));
                    System.out.println("my port is: " + randomPort);
                    ByteBuffer byteBuffer = ByteBuffer.allocate(200);
                    while (true) {
                        System.out.println("--Server wait for connection--1");
                        SocketChannel sChannel = serverSocketChannel.accept();
                        System.out.println("--Server wait for connection--2");
                        while (byteBuffer.hasRemaining()) {

                            int readed =sChannel.read(byteBuffer);
                            String msg = new String(byteBuffer.array(),0,readed);

                            //sb.append(sChannel.getRemoteAddress() + " " + new String(buffer.array(), 0, read) + "\n");
                            messeges.add(msg);
                            byteBuffer.clear();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Server server = new Server();
        server.start();
    }


    @Override
    public void handle(Event event) {
        String name = ((Button) (event.getSource())).getText();
        System.out.println(name);

        switch (name) {
            case "Connect":
                try {
                    socketChannel = SocketChannel.open(new InetSocketAddress(tfIpAdress.getText(), Integer.parseInt(tfPort.getText())));
                    byteBuffer = ByteBuffer.allocate(200);
                    messeges.add("conected: " + socketChannel.isConnected());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Send!":
                try {
                    byteBuffer = ByteBuffer.allocate(200);
                    byteBuffer.put(tfSetMess.getText().getBytes());
                    messeges.add(tfSetMess.getText());
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    tfSetMess.clear();
                    byteBuffer.clear();

                } catch (Exception e) {
                    e.printStackTrace();
                }


                break;
        }
    }
}
class AsyncChatTest{


}