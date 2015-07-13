package session4;

import javafx.application.Application;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * Created by GFalcon on 26.05.15.
 */
public class TreeXML extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageView rootIcon = new ImageView(new Image(new FileInputStream("folder2.png")));
        TreeItem<String> root = new CheckBoxTreeItem<>("root", rootIcon);
        TreeView<String> tree = new TreeView<>(root);

        BorderPane pane = new BorderPane();

    }
}
