package session4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * Created by george on 26.05.15.
 */
public class javaFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageView rootIcon = new ImageView(new Image(new FileInputStream("folder2.png")));
        TreeItem<String> root = new CheckBoxTreeItem<String>("root", rootIcon);
        TreeView<String> tree = new TreeView<String>(root);

        for(int i =0;i<5;i++){
            root.getChildren().add(new TreeItem<String>("child-"+i));
        }
        root.setExpanded(true);

        BorderPane pane = new BorderPane();
        final TextArea text = new TextArea("Text\n");
        pane.setCenter(tree);
        pane.setTop(new TextArea("1\n2"));
//        pane.setBottom(new Button("Ok"));
        Button button = new Button("ok");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                text.appendText(" added\n");
            }
        });
//        pane.setTop(new TextArea("1\n2"));
//        pane.setBottom(new Button("Ok"));
//        Button button = new Button("ok");
//        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                text.appendText(" added\n");
//            }
//        });
        pane.setBottom(button);
        pane.setLeft(new Label("new text"));

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
