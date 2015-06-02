package lection02;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParsing extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        BorderPane pane = new BorderPane();
        TextField text = new TextField("xml");
        Button button = new Button("Parse");
        FlowPane flowPane = new FlowPane(text,button);
        pane.setTop(flowPane);

        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                text.setText("");
            }
        });

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                documentBuilderFactory.setValidating(false);
                DocumentBuilder builder = null;
                try {
                    builder = documentBuilderFactory.newDocumentBuilder();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
                Document document = null;
                try {
                    if (text.getText().contains(":"))
                        document = builder.parse(new File(text.getText()));
                    else
                        document = builder.parse(new File("C:\\Users\\Taras\\Desktop\\Denst\\proff25\\den_storozhenko\\src\\main\\java\\lection02\\" + text.getText()));
                } catch (SAXException e) {
                    e.printStackTrace();
                    stage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    stage.close();
                }
                Node node = document.getDocumentElement(); // �������� �������
                TreeItem<String> root = new CheckBoxTreeItem<>();
                root.setExpanded(true);
                recursDom(node, root);

                TreeView<String> tree = new TreeView<>(root.getChildren().get(0));
                pane.setCenter(tree);
            }
        });

        Scene scene = new Scene(pane, 600, 400);

        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
        text.setMinWidth(scene.getWidth() * 0.9);
        button.setMinWidth(scene.getWidth() * 0.1);


        //stage.setMaximized(true);
    }

    public static void recursDom(Node node, TreeItem<String> root){
        if (node.getNodeType()!=Node.TEXT_NODE) {
            root.getChildren().add(new TreeItem<>(node.getNodeName()));
            //System.out.print(node.getNodeName());
        }
        NodeList nodeList = node.getChildNodes();
        if (nodeList.getLength()==0){
            if (!node.getTextContent().contains(" ")) {
                root.getChildren().add(new TreeItem<>(node.getTextContent()));
            }
            //System.out.print(" " + node.getTextContent());
        }
        else {
            for (int i = 0; i < nodeList.getLength(); i++) {
                recursDom(nodeList.item(i),root.getChildren().get(root.getChildren().size() - 1));
            }
        }
    }
}
