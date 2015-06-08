package asyncchat.javafxversion;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by IEvgen Boldyr on 07.06.15.
 * Project: proff25
 */

public class ServerASyncChatJavaFX extends Application {

    private ServerSocketChannel ssc;
    private SocketChannel channel;
    private ByteBuffer buffer = ByteBuffer.allocate(128);
    private TextArea area;
    private TextField message;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX - ASyncChatServer");
        BorderPane primary = new BorderPane();

        BorderPane connection = new BorderPane();
        Button start = new Button("Start server");
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ssc = ServerSocketChannel.open();
                            ssc.bind(new InetSocketAddress(30000));
                            channel = ssc.accept();
                            startReceiveMessages();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
        connection.setCenter(start);

        BorderPane chat = new BorderPane();
        area = new TextArea();
        area.setEditable(false);
        chat.setCenter(area);

        BorderPane sender = new BorderPane();
        message = new TextField();
        Button send = new Button("Send");
        send.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    sendMessage(message.getText(), buffer);
                    area.appendText("Server : " + message.getText() + "\n");
                    message.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        sender.setCenter(message);
        sender.setRight(send);

        primary.setTop(connection);
        primary.setCenter(chat);
        primary.setBottom(sender);

        Scene scene = new Scene(primary, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void sendMessage(String message, ByteBuffer buffer) throws IOException {
        buffer.put(message.getBytes());
        while (buffer.hasRemaining()) {
            buffer.flip();
            channel.write(buffer);
        }
        buffer.clear();
    }

    private void inputMessage(ByteBuffer buffer) {
        try {
            int bytesRead;
            while ((bytesRead = channel.read(buffer)) > 0) {
                buffer.flip();
                area.appendText("Client : " + new String(buffer.array(), 0, bytesRead) + "\n");
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startReceiveMessages() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ByteBuffer buffer = ByteBuffer.allocate(128);
                inputMessage(buffer);
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
