package session4;/**
 * Created by ivan on 26.05.15.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new TextField("text"));
        borderPane.setCenter(new TextArea("qwerty"));
        borderPane.setLeft(new Label("Some text is here"));
        borderPane.setBottom(new Button("Ok"));
        Scene scene = new Scene(new Label("hi!"),600,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
