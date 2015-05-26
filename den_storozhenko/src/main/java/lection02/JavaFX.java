package lection02;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by storo_000 on 26.05.2015.
 */
public class JavaFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        TextField text = new TextField("text");
        TextArea textArea = new TextArea("1\n2\n");
        pane.setTop(text);
        pane.setCenter(textArea);
        pane.setLeft(new Label("PROST TEXT"));
        //pane.setBottom(new Button("OK"));

        Button button = new Button("OK");
        //button.setOnMouseClicked(event -> text.appendText(button.getText()));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //text.appendText(button.getText());
                textArea.appendText(button.getText()+"\n");
            }
        });
        pane.setBottom(button);
        Scene scene = new Scene(pane, 600 ,400);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }
}
