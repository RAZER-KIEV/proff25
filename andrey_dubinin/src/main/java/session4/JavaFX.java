package session4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

import java.io.FileInputStream;

/**
 * Created by jax on 26.05.15.
 */
public class JavaFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        //TreeItem<String> root = new CheckBoxTreeItem<>("root",rootIcon);
        //TreeView<String> tree = new TreeView<>(root);
        //for(int i=0;i<3;i++){
          //  root.getChildren().add(new TreeItem<>());
        //}
        BorderPane pane = new BorderPane();
        TextField text = new TextField("text");
        pane.setTop(text);
        pane.setCenter(new TextArea("1\n2"));
        pane.setLeft(new Label("Просто текст"));
        Button button = new Button("OK");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                text.appendText(button.getText());
            }
        });
        pane.setBottom(button);

        Scene scene = new Scene(pane,600,400);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }
}
