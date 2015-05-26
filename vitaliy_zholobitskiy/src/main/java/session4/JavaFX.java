package session4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by just1ce on 26.05.2015.
 */
public class JavaFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane= new BorderPane();
        borderPane.setTop(new TextField("Hello from GUI"));
        borderPane.setCenter(new Label("centre"));
        java.awt.Button b= new java.awt.Button("click me");
        //b.
        //b.setOnAction(new EventHandler<ActionEvent>() {
            //@Override
            //public void handle(ActionEvent event) {
              //  System.out.println("Hello World!");
           // }
       // });
        borderPane.setBottom(new Button("Click Me!"));
        Scene scene= new Scene(borderPane,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
