package hw3.chat;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by ivan on 04.07.15.
 */
public class AsyncChat extends Application {

    public void process(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5, 5, 5, 5));

        Text exampleText = new Text();

        TextArea ip = new TextArea("type ip address here");
        ip.setMaxSize(200, 15);

        ip.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ip.setText("");
            }
        });

        TextArea port = new TextArea("type port here");
        port.setMaxSize(200, 15);

        port.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                port.setText("");
            }
        });

        Button connect = new Button("connect");

        connect.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        connect.setMaxSize(100, 15);
        FlowPane flowPaneConnect = new FlowPane(ip,port,connect);
        flowPaneConnect.setVgap(5);
        flowPaneConnect.setHgap(5);

        TextArea chatText = new TextArea();
        chatText.setEditable(false);
        FlowPane flowPaneCaht = new FlowPane(chatText);

        TextField message = new TextField("your message...");
        Button send = new Button("send");
        FlowPane flowPaneMessage = new FlowPane(message, send);

        borderPane.setTop(flowPaneConnect);
        borderPane.setCenter(flowPaneCaht);
        borderPane.setBottom(flowPaneMessage);

        Scene scene = new Scene(borderPane, 800, 600);


        primaryStage.setTitle("Chat by Ivan, version: 1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
       new AsyncChat().process(args);
    }

}

