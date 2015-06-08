package hw3.chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Sveta on 6/3/2015.
 */
public class AsyncChat extends Application {
    String ip;
    int port;
    String text;
    String txt;
    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();
        TextField message = new TextField();
        TextField ipField = new TextField();
        TextField portField = new TextField();
        TextArea messageHistory = new TextArea();
        Button sendButton = new Button();
        Button connect = new Button("Connect");


        sendButton.setPrefHeight(50);
        sendButton.setGraphic(new ImageView("http://www.energizesoftware.com/images/envelope.gif"));
        message.setPrefSize(350, 50);
        messageHistory.setWrapText(true);

        connect.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ip = ipField.getText();
                port = Integer.parseInt(portField.getText());
                messageHistory.appendText("Hello! ^-^ \n");
                try {
                    process();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                txt = message.getText();
                messageHistory.appendText(ip + ": " + txt + "\n");
                message.setText("");
                if(text != null){
                    messageHistory.appendText(ip + ": " + text + "\n");
                }


            }
        });

        pane.setTop(new HBox(new Label("  IP:  "), ipField, new Label("  Port:  "), portField, connect));
        pane.setCenter(messageHistory);
        pane.setBottom(new HBox(message, sendButton, new ImageView("https://pp.vk.me/c627320/v627320486/4601/MEyhmf5UyhE.jpg")));

        Scene scene = new Scene(pane, 910, 600);
        primaryStage.getIcons().add(new Image("http://upload.wikimedia.org/wikipedia/commons/3/3d/My_personal_black_cat.gif"));
        primaryStage.setTitle("ChattyCat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void process() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
//        SocketChannel serverChannel = serverSocketChannel.accept();
        ByteBuffer serverBuffer = ByteBuffer.allocate(50);
        ByteBuffer clientBuffer = ByteBuffer.allocate(50);
        SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress(ip, port));

        clientBuffer.flip();
        text = String.valueOf(clientChannel.write(clientBuffer));
        clientBuffer.clear();
        serverBuffer.put(txt.getBytes());
        serverBuffer.flip();
//        while (serverBuffer.hasRemaining()) {
//            serverChannel.write(serverBuffer);
//        }
//        serverBuffer.rewind();



    }
}

class AsyncChatTest {

}
