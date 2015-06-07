package session4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.applet.Applet;
import java.io.FileInputStream;

/**
 * Created by oleg on 26.05.15.
 */
public class JavaFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
//        Node rootItem = new ImageView(new Image(new FileInputStream("/home/oleg/Downloads/Eg2i3_dbEk8.jpg")));
        Node rootItem =  FXMLLoader.load(getClass().getResource("/home/oleg/IdeaProjects/proff25/oleg_chumak/Group"));
//        TreeView<String> tree = new TreeView<>(root);
//        for(int i = 0; i < 5; i++) {
//            root.getChildren().add(new TreeItem<>("child-" + i));
//        }

        TextField textField = new TextField("text");
        pane.setTop(textField);
        pane.setCenter(rootItem);
        pane.setLeft(new Label("just any text"));
        Button button = (new Button("OK"));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                textField.appendText(button.getText());
            }
        });
        pane.setBottom(button);

        Scene scene = new Scene(pane, 1050, 700);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }
}
