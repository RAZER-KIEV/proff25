package hw6;/**
 * Created by ivan on 17.06.15.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class Menu extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);

        BorderPane borderPane = new BorderPane();

        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setTitle("`NOTEBOOK`shop by ivan");
        primaryStage.setScene(scene);
        primaryStage.show();

        TextArea outputInfo = new TextArea();
        outputInfo.setEditable(false);
        borderPane.setLeft(outputInfo);


//        TextField ipText = new TextField("localhost");
//        TextField portText = new TextField("30000");
//        Button connectButton = new Button("Connect");
//        FlowPane connect = new FlowPane(ipText, portText, connectButton);
//        borderPane.setTop(connect);
//
//        TextArea chatText = new TextArea();
//        chatText.setEditable(false);
//        borderPane.setCenter(chatText);
//
//        TextField messageText = new TextField();
//        Button sendMessageButton = new Button("Send");
//
//        Text errorText = new Text(" ");
//        errorText.setFill(Color.RED);
//        FlowPane message = new FlowPane(messageText,sendMessageButton, errorText);
//        borderPane.setBottom(message);

    }
}
