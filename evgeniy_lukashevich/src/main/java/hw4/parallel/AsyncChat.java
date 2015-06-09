package hw4.parallel;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.InetSocketAddress;

/**
 * Написать чат, в котором можно отправлять и принимать сообщения в любом порядке.
 public void process()

 Класс задания hw3.chat.AsyncChat
 Класс теста hw3.chat.AsyncChatTest
 * Created by lukashevich.e on 03.06.2015.
 */
public class AsyncChat extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button buttonConnect = new Button("Connect");
        Button buttonSend = new Button("Send");
        buttonConnect.setPrefSize(100, 25);
        buttonSend.setPrefSize(100, 80);
        Label labelIPPort = new Label("Enter IP and port");

        TextField textIP = new TextField();
        TextField textPort = new TextField();
        textIP.setPrefSize(350, 25);
        textPort.setPrefSize(350, 25);

        buttonConnect.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickConnect(textIP.getText(), Integer.valueOf(textPort.getText()));
            }
        });

        TextArea message = new TextArea();
        message.setPrefSize(750, 80);
        TextArea dialogue = new TextArea();

        BorderPane pane = new BorderPane();
        BorderPane paneTop = new BorderPane();
        BorderPane paneBottom = new BorderPane();

        paneTop.setRight(buttonConnect);
        paneTop.setTop(labelIPPort);
        paneTop.setLeft(textIP);
        paneTop.setCenter(textPort);
        paneBottom.setRight(buttonSend);
        paneBottom.setCenter(message);
        pane.setBottom(paneBottom);
        pane.setTop(paneTop);
        pane.setCenter(dialogue);

        Scene scene = new Scene(pane, 900, 600);
        stage.setTitle("Asynch Chat");
        stage.setScene(scene);
        stage.show();
    }

    public void clickConnect (String ip, int port) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(ip, port);

    }
}
