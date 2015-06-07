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

    static ObservableList<String> messeges = FXCollections.observableArrayList("Привет!", "халоу", "как оно?");
    static TextField tfPort;
    static TextField tfIpAdress;
    static SocketAddress localIP;
    static SocketAddress remoteIP;
    static boolean isConnected=false;
    static SocketChannel socketChannel;
    static ByteBuffer byteBuffer;
    static TextField tfSetMess;

    public static void main(String[] args) throws IOException {

        // ObservableList<String> messeges = FXCollections.observableArrayList("Привет!", "халоу", "как оно?");
        //Start()

        ByteBuffer buffer3;
        int port = 30069;
        String ipAddress = "127.0.0.1";
        boolean once = true;

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));



        //Server realize realize
        while (true) {
            socketChannel = serverSocketChannel.accept();
            System.out.println("SERVER: while works!");

            isConnected = socketChannel.isConnected();

        if (isConnected) {
            localIP = socketChannel.getLocalAddress();
            remoteIP = socketChannel.getRemoteAddress();

            byteBuffer = ByteBuffer.allocate(1000);
            socketChannel.read(byteBuffer);
            // ?? socketChannel.write(byteBuffer);
            String inMessege = String.valueOf(byteBuffer.array());
            System.out.println("resived messege: "+inMessege);
            byteBuffer.clear();

            if (isConnected && once) {
                messeges.add(String.join("Connection established! with " + String.valueOf(remoteIP)));
                System.out.println(localIP + ": Connection established! with - " + remoteIP);
                byteBuffer.put("Connektion Established with ".getBytes());
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
                messeges.add("Connektion Established with ");

                byteBuffer.put(String.valueOf(localIP).getBytes());
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
                once = false;
            }


            messeges.add(inMessege);
            byteBuffer.clear();
         }
      }
           
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
        messeges.add("tgnf");
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

    }

    @Override
    public void handle(Event event) {
        String name = ((Button) (event.getSource())).getText();
        System.out.println(name);

        switch (name) {
            case "Send!":
                ByteBuffer buffer3 = ByteBuffer.allocate(1000);

                String msg = tfSetMess.getText();
                System.out.println(msg);
                messeges.add(msg);
                 // byteBuffer.clear();
                buffer3.flip();
                buffer3.put(msg.getBytes());
                try {
                    socketChannel.write(buffer3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                buffer3.clear();
                 //todo
                System.out.println("send pressed");
                break;
            case "Connect":

                   System.out.println("try conn");
                 //String s =(tfPort.getText());
                  // System.out.println(s);
                 ///int port;
                int port = Integer.parseInt(tfPort.getText());
                System.out.println("port: " +port);
                String ip = tfIpAdress.getText();
                   System.out.println("IP: "+ip);
                String connEsteblishReqest = "request connection";

               try{
                   SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(ip, port));
                ByteBuffer buffer2 = ByteBuffer.allocate(1000);
                isConnected = socketChannel.isConnected();
                   System.out.println(isConnected);
                //socketChannel.write(buffer);
                buffer2.put(connEsteblishReqest.getBytes());
                buffer2.flip();
                messeges.add("add to ListView");
                //buffer.put(String.valueOf(localIP).getBytes());

                System.out.println("Connect pressed");
                System.out.println("connected: " + isConnected);
                  buffer2.clear();

                break;
               }catch (Exception e){
                   System.out.println(e);
               }
        }
    }
}