package session4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class JavaFX extends Application {
    public void start(Stage stage) throws Exception {
        BorderPane pane=new BorderPane();
        pane.setTop(new TextField("text"));
        pane.setLeft(new Label("посто текст"));
        pane.setCenter(new TextArea("textarea"));
        pane.setBottom(new Button("OK"));
        Scene scene=new Scene(pane, 600, 400);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }
}
