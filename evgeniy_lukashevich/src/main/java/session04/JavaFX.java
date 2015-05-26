package session04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Jeckgehor on 26.05.2015.
 */
public class JavaFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setTop(new TextField("text"));
        pane.setCenter(new TextArea("Open \n 12"));
        pane.setBottom(new Button("Ron"));
        pane.setLeft(new Label("Potter fogol moment"));
        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("Hello, FX");
        stage.setScene(scene);
        stage.show();
    }
}
