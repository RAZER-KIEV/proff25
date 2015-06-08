package session4;

import android.content.DialogInterface;
import android.view.View;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;


public class JavaFX extends Application implements EventHandler {
    public static void main(String[] args) {
        Application.launch(JavaFX.class, args);
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

        TextField tfIpAdress = new TextField("Set Partner IP.");
        ;
        tfIpAdress.setPrefSize(200, 30);
        tfIpAdress.setEditable(true);
        tfIpAdress.setEffect(dropShadow);

        TextField tfPort = new TextField("Set Partner port.");
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


        ObservableList<String> messeges = FXCollections.observableArrayList(
                "Привет!", "халоу", "как оно?");
        ListView<String> mainJournal = new ListView<String>(messeges);
        mainJournal.setOrientation(Orientation.VERTICAL);
        mainJournal.setEffect(dropShadow);
        mainJournal.setVisible(true);
        mainJournal.setPrefSize(500, 400);
        mainJournal.setLayoutX(10);
        mainJournal.setLayoutY(50);

        pane.setCenter(mainJournal);
        root.getChildren().add(pane);


        TextField tfSetMess = new TextField(" ");
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
        String conn=event.getSource().toString();
       String send;
        System.out.println(event.getEventType().getName());
        //switch (event.getTarget()) {
            //case "Connect":
                //.out.println("Connekt Pressed!!!");



        }


    }
