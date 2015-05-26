package session4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by jax on 26.05.15.
 */
public class JavaFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Label("hi"), 600,400);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }
}
