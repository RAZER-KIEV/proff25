package main.session4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;

/**
 * Created by george on 26.05.15.
 * построть рекурсивным методом
 */
public class javaFxTree extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        FileInputStream file = new FileInputStream("file.xml");

        Button button = new Button("Ok");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                     @Override
                                     public void handle(MouseEvent event) {

                                     }
                                 }
        );

        TextArea text = new TextArea();
//        pane.setLeft();
        pane.setRight(button);
        pane.setBottom(text);

    }
}
