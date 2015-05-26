package session4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by jax on 26.05.15.
 */
public class JavaFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setTop(new TextField("text"));
        pane.setCenter(new TextArea("1\n2"));
        pane.setLeft(new Label("Просто текст"));
        pane.setBottom(new Button("OK"));

        Scene scene = new Scene(pane,600,400);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }
}
