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
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by viktoria on 26.05.15.
 */
public class AppJavaFX extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        ImageView rootIcon = new ImageView(new Image(new FileInputStream("folder2.png")));
        TreeItem<String> root = new CheckBoxTreeItem<>("root", rootIcon);
        TreeView<String> tree = new TreeView<>(root);
        for (int i = 0; i < 5; i++) {
            root.getChildren().add(new TreeItem<>("child-" + i));
        }
        root.setExpanded(true);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("Group.xml"));



        BorderPane pane = new BorderPane();
        pane.setLeft(new TextArea(doc.getNodeName()));






        TextField text = new TextField("text");
        pane.setTop(text);
        pane.setCenter(tree);
        pane.setLeft(new Label("Просто какой то текст"));
        Button button = new Button("Ok");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                text.appendText(button.getText());
            }
        });
        pane.setBottom(button);

        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }

}
