package session4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by IEvgen Boldyr on 26.05.15.
 * Project: proff25
 */

public class JavaFXTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setTop(new TextField("text"));
        TextArea textArea = new TextArea("Area");
        pane.setCenter(textArea);
        pane.setLeft(new Label("LAbel"));
        Button button = new Button("OK");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                textArea.setText(button.getText());
            }
        });
        pane.setBottom(button);
        Scene scene = new Scene(pane, 800, 600);

        primaryStage.setTitle("HelloFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
