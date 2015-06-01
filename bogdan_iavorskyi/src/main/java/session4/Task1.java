package session4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * Created by bosyi on 26.05.15.
 */
public class Task1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        TextField textField = new TextField("");
        /*TreeItem<String> root = new CheckBoxTreeItem<>("root");
        TreeView<String> tree = new TreeView<>(root);
        for (int i = 0; i < 5; i++) {
            root.getChildren().add(new TreeItem<>("child"+1));
        }
        root.setExpanded(true);*/
        BorderPane pane = new BorderPane();
        pane.setTop(new TextField("tess"));
        //pane.setCenter(tree);
        Button button = new Button("Ok");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        FlowPane flowPane = new FlowPane(textField,button);
        pane.setTop(flowPane);
        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("my new app");
        stage.setScene(scene);
        stage.show();
    }
}
