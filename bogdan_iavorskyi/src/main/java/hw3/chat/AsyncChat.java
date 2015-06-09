package hw3.chat;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by bosyi on 08.06.15.
 */
public class AsyncChat extends Application {

    private enum Role {ROBOT, YOU, GUEST}
    private Role robotRole = Role.ROBOT;
    private Role youRole = Role.YOU;
    private Role guestRole = Role.GUEST;

    private SocketChannel socketClientChannel;
    TextArea messagesTextArea;

    public void process() {};

    @Override
    public void start(Stage stage) throws Exception {


        // TextFields
        TextField ipAddressTextField = new TextField();
        TextField portTextField = new TextField();
        TextField messageTextField = new TextField();
        TextField serverPortTextField = new TextField();

        // Buttons
        Button connectButton = new Button("Connect");

        connectButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startClient(ipAddressTextField.getText(), Integer.parseInt(portTextField.getText()));
                    }
                }).start();
            }
        });

        Button serverCreateButton = new Button("Start Server");

        serverCreateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startServer(Integer.parseInt(serverPortTextField.getText()));
                    }
                }).start();
            }
        });

        Button sendMessageButton = new Button("Send");

        sendMessageButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    if (messageTextField.getText().length() > 0) {
                        sendMessage(messageTextField.getText());
                    }
                } catch (Exception e) {
                    generateMessage(robotRole, e.getClass().getSimpleName() + ":" + e.getMessage());
                } finally {
                        messageTextField.setText("");
                }
            }
        });

        // TextArea for messages
        messagesTextArea = new TextArea();

        // Top Flow pane
        FlowPane topFlowPane = new FlowPane();
        topFlowPane.getChildren().add(ipAddressTextField);
        topFlowPane.getChildren().add(portTextField);
        topFlowPane.getChildren().add(connectButton);
        topFlowPane.getChildren().add(serverPortTextField);
        topFlowPane.getChildren().add(serverCreateButton);

        // Bottom Flow pane
        FlowPane bottomFlowPane = new FlowPane();
        bottomFlowPane.getChildren().add(messageTextField);
        bottomFlowPane.getChildren().add(sendMessageButton);

        // BorderPane to handle all elements
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topFlowPane);
        borderPane.setCenter(messagesTextArea);
        borderPane.setBottom(bottomFlowPane);

        // Create Scene
        Scene scene = new Scene(borderPane, 800, 600);

        stage.setTitle("Asynchronous Chat");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                stage.close();
            }
        });
    }

    public void startServer(int port) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer buffer = ByteBuffer.allocate(128);

            int bytesRead;
            while ((bytesRead = socketChannel.read(buffer)) > 0) {
                generateMessage(guestRole, new String(buffer.array(), 0, bytesRead));
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startClient(String ipAddress, int port) {
        try {
            socketClientChannel = SocketChannel.open(new InetSocketAddress(ipAddress, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        byte[] messageByteArray = message.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(messageByteArray.length);
        byteBuffer.put(messageByteArray);
        byteBuffer.flip();
        try {
            while (byteBuffer.hasRemaining()) {
                socketClientChannel.write(byteBuffer);
            }
            generateMessage(youRole, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateMessage(Role role, String message) {
        StringBuilder str = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String time = simpleDateFormat.format(calendar.getTime());
        str.append(time);
        str.append("   [" + role.name() + "] : ");
        str.append(message + "\n");
        messagesTextArea.appendText(str.toString());
    }

}
