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
import session6.Server;

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
                    try {
                        process();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                txt = message.getText();
                messageHistory.appendText(ip + " 1: " + txt + "\n");
                message.setText("");
                if(text != null){
                    messageHistory.appendText(ip + " 2: " + text + "\n");
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
    public void process() throws IOException, InterruptedException {
        // For receiving
        new Thread(){
            @Override
            public void run() {
                ServerSocketChannel serverSocketChannel = null;
                try {
                    serverSocketChannel = ServerSocketChannel.open();
                    serverSocketChannel.socket().bind(new InetSocketAddress(30000));
                    SocketChannel serverChannel = serverSocketChannel.accept();
                    ByteBuffer serverBuffer = ByteBuffer.allocate(50);
                    while (!(serverBuffer.hasRemaining())) {
                        try {
                            serverSocketChannel.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    serverBuffer.rewind();

                    int bytesRead;
                    bytesRead = serverChannel.read(serverBuffer);
                    System.out.println(new String(serverBuffer.array(), 0, bytesRead));


                    serverBuffer.clear();
                    serverBuffer.put("You are".getBytes());
                    serverBuffer.flip();
                    while (serverBuffer.hasRemaining()) {

                        serverChannel.write(serverBuffer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }.start();

        // For sending
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(ip, port));

        ByteBuffer buffer = ByteBuffer.allocate(50);
        buffer.put(txt.getBytes());

        buffer.flip();
        while (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
        buffer.rewind();

        int intMessage;
        intMessage = socketChannel.read(buffer);
        text = String.valueOf(intMessage);
    }


}

class AsyncChatTest {

}
