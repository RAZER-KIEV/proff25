package session4;/**
 * Created by ivan on 26.05.15.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class JavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Label("hi!"),600,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
