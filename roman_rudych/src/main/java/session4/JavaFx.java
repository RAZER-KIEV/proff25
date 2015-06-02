package session4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Роман on 26.05.2015.
 */
public class JavaFx extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane pane = new BorderPane();
        TextField text = new TextField("/c:/ITC");
        pane.setTop(text);
        Button button = new Button("Read XML");
        pane.setRight(button);

        button.setOnMouseClicked(mouseEvent -> {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(new File(text.getText()));
                Element el = doc.getDocumentElement();
                NodeList ls = el.getChildNodes();
                TreeItem<String> item = new CheckBoxTreeItem<String>(el.getNodeName(),
                        new ImageView(new Image(new FileInputStream("folder2.png"))) );
                TreeView<String> tree = new TreeView<String>(getItemsFromDocFull(ls.item(1), item));
                pane.setCenter(tree);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }

    private TreeItem<String> getItemsFromDoc (org.w3c.dom.Node el, TreeItem<String> item) throws FileNotFoundException {
        TreeItem<String> root=null;
        if(!el.getNodeName().contains("#")) {
            root = new CheckBoxTreeItem<>(el.getNodeName(),
                        new ImageView(new javafx.scene.image.Image(new FileInputStream("folder2.png"))));
            root.setExpanded(true);
            item.getChildren().add(root);
        }
        if(el.hasChildNodes()) {
            NodeList list = el.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
               if(root != null)
                    getItemsFromDoc(list.item(i), root);
                else
                   getItemsFromDoc(list.item(i), item);
            }
        }
        return item;

    }

    private TreeItem<String> getItemsFromDocFull (org.w3c.dom.Node el, TreeItem<String> item) throws FileNotFoundException {
        TreeItem<String> root=null;
        if(!el.getNodeName().contains("#")) {
            if(el.getChildNodes().getLength() == 1) {
                root = new CheckBoxTreeItem<>(el.getNodeName(),
                        new ImageView(new javafx.scene.image.Image(new FileInputStream("folder2.png"))));
                root.setExpanded(true);
                root.getChildren().add(new CheckBoxTreeItem<>(el.getTextContent(),
                        new ImageView(new Image(new FileInputStream("/C:/text_resize.png")))));
                item.getChildren().add(root);

            } else {
                root = new CheckBoxTreeItem<>(el.getNodeName(),
                        new ImageView(new javafx.scene.image.Image(new FileInputStream("folder2.png"))));
                root.setExpanded(true);
                item.getChildren().add(root);
            }
        }
        if(el.hasChildNodes()) {
            NodeList list = el.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                if(root != null)
                    getItemsFromDocFull(list.item(i), root);
                else
                    getItemsFromDocFull(list.item(i), item);
            }
        }
        return item;

    }
}
