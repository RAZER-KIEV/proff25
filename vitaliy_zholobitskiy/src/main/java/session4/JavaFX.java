package session4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.reflect.generics.tree.Tree;

import javax.swing.text.html.ImageView;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.List;

/**
 * Created by just1ce on 26.05.2015.
 */
public class JavaFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setValidating(false);
        DocumentBuilder dBuilder = null;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("vitaliy_zholobitskiy//data.xml"));
        Node node =doc.getDocumentElement();
        node.normalize();
        NodeList l= node.getChildNodes();
        TreeItem<String> root1 = new CheckBoxTreeItem<>("root");
        TreeView<String> tree = new TreeView<>(root1);
       // for(int i=0;i<l.getLength();i++){
           // if (l.item(i).getNodeType()==Node.ELEMENT_NODE) {
               // TreeItem t1 =new TreeItem<>(root.getNodeName());
                //tree.getChildren().add(t1);

          //  }
       // }
        //recursDom(node, root1);

        BorderPane borderPane= new BorderPane();
        Button b= new Button("Read");
        TextField textField= new TextField("");
        borderPane.setTop(textField);
        borderPane.setRight(b);
        //TreeItem<String> root = new CheckBoxTreeItem<>("root");
        //TreeView<String> tree = new TreeView<>(root);

        borderPane.setCenter(tree);


        Scene scene= new Scene(borderPane,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void recursDom(Node root, TreeItem t){

        if (root.getNodeType()==Node.ELEMENT_NODE) {
            TreeItem t1 =new TreeItem<>(root.getNodeName());
            t.getChildren().add(t1);

        }
        NodeList nodeList = root.getChildNodes();
        if (nodeList.getLength()==0){

            //t.getChildren().add(new TreeItem<>(root.getNodeValue()));

            //System.out.print(" "+root.getNodeValue());
        }
        else {
            TreeItem t1 = new TreeItem<>(root.getNodeName());

            for (int i = 0; i < nodeList.getLength(); i++) {
                recursDom(nodeList.item(i), t1);
            }
        }
    }


}
