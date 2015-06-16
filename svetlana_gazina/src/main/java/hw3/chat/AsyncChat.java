package hw3.chat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by Sveta on 8/3/2015.
 */
public class AsyncChat extends Application {
    private final TextArea messageHistory = new TextArea();
    private String ip;
    private int port;
    private Boolean stopping = false;
    private ServerSocketChannel serverSocketApp;
    private SocketChannel socketChannelApp;
    private Thread processThread;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();
        final TextField message = new TextField();
        final TextField ipField = new TextField();
        final TextField portField = new TextField();
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

                process();

                messageHistory.appendText("Connected: \n");
            }
        });
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String txt = message.getText();
                messageHistory.appendText("you: " + txt + "\n");
                message.setText("");
                send(txt);
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

    @Override
    public void stop(){
        stopping = true;
        try {
            socketChannelApp.close();
            serverSocketApp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            processThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void process() {
        // For receiving
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                // Create a Server socket channel.
                try (ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
                    serverSocketApp = serverSocket;
                    // Bind the server socket channel to the IP address and Port
                    serverSocket.bind(new InetSocketAddress(port));

                    while (true) {
                        if (stopping){
                            System.out.println("Stopped");
                            return;
                        }

                        //Wait and Accept the client socket connection.
                        try (SocketChannel socketChannel = serverSocket.accept()) {
                            socketChannelApp = socketChannel;
                            //Printing the address of the client.
                            System.out.println("Obtained connection from: "+socketChannel.getRemoteAddress().toString());
                            //Creating a reader for reading the content on the socket input stream.
                            Scanner socketReader = new Scanner(socketChannel.socket().getInputStream());
                            while(socketReader.hasNext()){
                                if (stopping){
                                    System.out.println("Stopped");
                                    return;
                                }

                                //Reading the content of the socket input stream.
                                String s = socketReader.nextLine();
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run(){
                                        messageHistory.appendText("friend: " + s + "\n");
                                    }
                                });
                            }
                        } catch(IOException ex){
                            ex.printStackTrace();
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };

        processThread = new Thread(runnable);
        processThread.start();
    }

    public void send(String s) {
        //Create a client socket.
        try(SocketChannel socketChannel = SocketChannel.open()){
            //Bind the client socket to the server socket.
            socketChannel.connect(new InetSocketAddress(ip, port));
            //Writing to the socket channel.
            PrintWriter writer = new PrintWriter(socketChannel.socket().getOutputStream(), true);
            writer.println(s);

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}

class AsyncChatTest {

}
