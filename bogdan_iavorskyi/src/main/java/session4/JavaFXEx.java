package session4;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;


/**
 * Created by bosyi on 26.05.15.
 */
public class JavaFXEx extends Application {

    private Document document;

    @Override
    public void start(Stage stage) throws Exception {
//        ImageView rootIcon = new ImageView(new Image(new FileInputStream("folder2.png")));
//        TreeItem<String> root = new /*CheckBox*/TreeItem<>("root", rootIcon);
//        TreeView<String> tree = null;
//        ObservableList<TreeItem<String>> observableList = root.getChildren();
//        observableList.add(new TreeItem<>("test"));
//        observableList.get(0).getChildren().add(new TreeItem<>("test2"));

//        root.setExpanded(true);
        BorderPane pane = new BorderPane();
        FlowPane flowPane = new FlowPane();
        TextField textField = new TextField();
//        textField.setMinWidth(100);
        Button button = new Button("Parse");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pane.setCenter(new TreeView<>(JavaFXEx.this.makeTree(textField.getText()).getChildren().get(0)));
            }
        });
        flowPane.getChildren().add(textField);
        flowPane.getChildren().add(button);
        pane.setTop(flowPane);
//        pane.setCenter(tree);



        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("my new app");
        stage.setScene(scene);
        stage.show();
    }

    public TreeItem<String> makeTree(String str) {
        TreeItem<String> root = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(str));
//            this.document = document;
            root = new /*CheckBox*/TreeItem<>("root");
            makeTreeHelper(root,document.getDocumentElement());
//            play(document);
//            print(document.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }

    public void makeTreeHelper(TreeItem<String> item, Node node) {
        if (!node.hasChildNodes()) {
//            System.out.println(node.getTextContent());
            TreeItem<String> newItem = new TreeItem<>(node.getTextContent());
            item.getChildren().add(newItem);
            return;
        }
        TreeItem<String> newItem = new TreeItem<>(node.getNodeName());
        item.getChildren().add(newItem);
        NodeList list = node.getChildNodes();
        for(int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                makeTreeHelper(newItem, list.item(i));
            } else if (list.item(i).getNodeType() == Node.TEXT_NODE && list.getLength() == 1) {
                makeTreeHelper(newItem, list.item(i));
            }
        }
    }
}
