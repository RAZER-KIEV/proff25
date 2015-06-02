package session4;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by rrudych on 29.05.15.
 */
public class XmlFileToTreeView extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Xml file to Tree View");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 600, Color.BLACK );

        TextField textField = new TextField();
        textField.setLayoutX(20);
        textField.setLayoutY(20);
        textField.setCursor(Cursor.TEXT);
        textField.setPrefSize(250,20);
        textField.setTooltip(new Tooltip("Type XML File path"));
        textField.setEditable(true);
        textField.setPromptText("/C:/Directory/file.xml");

        Button btn = new Button("Convert to Tree");
        btn.setLayoutX(280);
        btn.setLayoutY(20);
        btn.setMinHeight(20);

        btn.setOnAction(event -> {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(new File(textField.getText()));
                Element el = doc.getDocumentElement();
                NodeList ls = el.getChildNodes();
                TreeItem<String> item = new CheckBoxTreeItem<String>(el.getNodeName(),
                        new ImageView(new Image(new FileInputStream("folder2.png"))) );
                TreeView<String> tree = new TreeView<String>(getItemsFromDocFull(ls.item(1), item));
//                pane.setCenter(tree);
                tree.setLayoutX(20);
                tree.setLayoutY(60);
                tree.setPrefSize(360,520);
                root.getChildren().add(tree);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        root.getChildren().addAll(btn, textField);
        primaryStage.setScene(scene);
        primaryStage.show();
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
