package session4;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * Created by Sveta on 5/26/2015.
 */
public class JavaFx extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Node rootIcon = new ImageView(new Image(new FileInputStream("image2.png")));
        TreeItem<String> root = new TreeItem<>("root", rootIcon);
        TreeView<String> tree = new TreeView<>(root);
        for (int i = 0; i < 5; i++) {
            root.getChildren().add(new TreeItem<String>("child-" + i));
        }
        root.setExpanded(true);
        BorderPane pane = new BorderPane();
        TextField text = new TextField("text");
        pane.setTop(text);
        pane.setCenter(tree);
        pane.setLeft(new Label("bla-bla-bla"));
        pane.setBottom(new Button("Ok"));

        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("First FX");
        stage.setScene(scene);
        stage.show();
    }
}
