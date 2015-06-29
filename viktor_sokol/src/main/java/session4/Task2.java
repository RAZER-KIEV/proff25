package session4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * Created by Віктор on 5/26/2015.
 */
public class Task2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        javafx.scene.image.ImageView rootIcon = new javafx.scene.image.ImageView(new Image(new FileInputStream("folder2.png")));
        TreeItem<String> root = new CheckBoxTreeItem<>("root", rootIcon);
        TreeView<String> tree = new TreeView<>(root);
        for (int i = 0; i < 5; i++) {
            root.getChildren().add(new TreeItem<>("child-" + i));
        }
        root.setExpanded(true);

        BorderPane pane = new BorderPane();
        TextField text = new TextField("text");
        pane.setTop(text);
        pane.setCenter(tree);

        Button button = new Button("read");
//        button.setOnMouseClicked(mouseEvent -> text.appendText(button.getText()));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                text.appendText(button.getText());
            }
        });
        pane.setBottom(button);

        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("TreeOfXml");
        stage.setScene(scene);
        stage.show();
    }
}
