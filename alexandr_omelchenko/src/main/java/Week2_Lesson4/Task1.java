package Week2_Lesson4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Task1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        TextField text = new TextField("insert file name");
        Button button = new Button("READ");
        pane.setTop(text);
        pane.setCenter(button);

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                     @Override
                                     public void handle(MouseEvent mouseEvent) {

                                         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                                         factory.setValidating(false);
                                         try {
                                             DocumentBuilder builder = factory.newDocumentBuilder();
                                             Document doc = builder.parse(new File(text.getText()));
                                             Node korn = doc.getDocumentElement();
                                             TreeItem<String> root = treeMaker(korn);

                                             TreeView<String> tree = new TreeView<>(root);
                                             root.setExpanded(true);
                                             pane.setBottom(tree);
                                         } catch (Exception e) {
                                             e.printStackTrace();
                                         }
                                     }
                                 }
        );
        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }
    public TreeItem treeMaker(Node element) {
        TreeItem<String> root = new CheckBoxTreeItem<>(element.getNodeName());
        tree(root, element);
      /*  NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                root.getChildren().add(new TreeItem<>(child.getNodeName()));
            }
        }*/
        return root;
    }
    public void tree(TreeItem item, Node el) {
        NodeList list = el.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node child = list.item(i);
            if (child instanceof Element) {
                TreeItem<String> temp = new TreeItem<>(child.getNodeName());
                item.getChildren().add(temp);

                NodeList nodelist = child.getChildNodes();
                if(nodelist.getLength()>0){
                tree(temp, child);}
            }
        }
    }
}