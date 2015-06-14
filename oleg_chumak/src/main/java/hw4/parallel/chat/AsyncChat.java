package hw4.parallel.chat;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class AsyncChat extends Application {

    //        212.90.61.116
    private TextArea textArea;
    private SocketChannel channelToServer;
    private Label status;
    StringBuilder chatting = new StringBuilder();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        process();
        primaryStage.setTitle("Чатец");
        Group root = new Group();
        Scene scene = new Scene(root, 425, 680, Color.AQUAMARINE);

        Label ip = new Label("Введите IP");
        ip.setLayoutX(60);
        ip.setLayoutY(10);

        Label port = new Label("Порт");
        port.setLayoutX(220);
        port.setLayoutY(10);

        status = new Label("Ожидание");
        status.setLayoutX(310);
        status.setLayoutY(10);

        TextField textIp = new TextField();
        textIp.setLayoutX(20);
        textIp.setLayoutY(27);
        textIp.setPrefSize(150, 15);
        textIp.setCursor(Cursor.TEXT);
        textIp.setTooltip(new Tooltip("Type IP adress"));
        textIp.setPromptText("127.0.0.1");
        textIp.setEditable(true);
        textIp.setText("");

        TextField textPort = new TextField();
        textPort.setLayoutX(180);
        textPort.setLayoutY(27);
        textPort.setPrefSize(105, 15);
        textPort.setCursor(Cursor.TEXT);
        textPort.setTooltip(new Tooltip("Type port"));
        textPort.setPromptText("1024 - 65535");
        textPort.setEditable(true);
        textPort.setText("");

        Button connectBtn = new Button("Подключиться");
        connectBtn.setLayoutX(290);
        connectBtn.setLayoutY(27);
        connectBtn.setMinSize(100, 15);

        textArea = new TextArea();
        textArea.setLayoutX(20);
        textArea.setLayoutY(60);
        textArea.setPrefSize(385, 550);

        TextField enterText = new TextField();
        enterText.setLayoutX(20);
        enterText.setLayoutY(630);
        enterText.setPrefSize(290, 20);

        Button sendBtn = new Button("Отправить");
        sendBtn.setLayoutX(315);
        sendBtn.setLayoutY(630);
        sendBtn.setMinSize(70, 20);

        root.getChildren().addAll(ip, port, textIp,
                textPort, connectBtn, textArea, enterText,
                sendBtn, status);
        primaryStage.setScene(scene);
        primaryStage.show();
        Thread serverThread = new Thread(new Handler());
        serverThread.start();

        connectBtn.setOnAction(event -> {
            try {
                channelToServer = SocketChannel.open(new InetSocketAddress(textIp.getText(), Integer.parseInt(textPort.getText())));
                if (channelToServer.isConnected()) {
                    status.setText("Подключено");
                }
            } catch (IOException ex) {
                status.setText("Беда-Печаль");
                ex.printStackTrace();
            }
        });

        enterText.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    ByteBuffer buf = ByteBuffer.allocate(100);
                    buf.put(enterText.getText().getBytes());
                    buf.flip();
                    channelToServer.write(buf);
                    textArea.setText(chatting.append("/Я "+enterText.getText()+ "\n").toString());
                    enterText.clear();
                } catch (IOException ex) {
                    status.setText("Беда - Печаль");
                    ex.printStackTrace();
                }
            }
        });
    }

    public void process() {
        System.out.println("Процесс пошел");
    }

    private class Handler implements Runnable{

        @Override
        public void run() {
            try {
                ServerSocketChannel ssChannel = ServerSocketChannel.open();
                ssChannel.socket().bind(new InetSocketAddress(30000));
                SocketChannel inputChannel = ssChannel.accept();
                while(true){
                    handle(inputChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
                status.setText("Беда - Печаль");
            }
        }

        private void handle(SocketChannel channel) throws IOException {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            int readed;
            while (buffer.hasRemaining()) {
                readed = channel.read(buffer);
                chatting.append(channel.getRemoteAddress() + " " + new String(buffer.array(), 0, readed) + "\n");
                textArea.setText(chatting.toString());
                buffer.clear();
            }
        }
    }
}