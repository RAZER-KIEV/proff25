package session04;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by Jeckgehor on 26.05.2015.
 */
public class TreeXML extends Application{

    String xmlText;

    @Override
    public void start(Stage stage) throws Exception {

        TreeItem<String> root = new CheckBoxTreeItem<>();
        TreeView<String> tree = new TreeView();
        tree.setPrefSize(600, 300);
        TextArea text = new TextArea();
        text.setPrefSize(700, 300);
        Button button = new Button("Record");
        button.setPrefSize(140, 50);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xmlText = text.getText();
                clickRecord();

            }
        });

        BorderPane pane = new BorderPane();
        pane.setLeft(text);
        pane.setRight(button);
        pane.setBottom(tree);

        Scene scene = new Scene(pane, 900, 600);
        stage.setTitle("Tree XML");
        stage.setScene(scene);
        stage.show();
    }

    public void clickRecord () {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            byte[] bytes = xmlText.getBytes("UTF-8");
            InputStream inputStream = new ByteArrayInputStream(bytes);
            Document doc = builder.parse(inputStream);
            Element root = doc.getDocumentElement();
            System.out.println(root.getTagName());
            visit(root, 0);
        } catch (Exception exceptions) {
            exceptions.printStackTrace();
        }
    }

    public static void visit(Node node, int level) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i);
            process(childNode, level + 1);
            visit(childNode, level + 1);
        }
    }

    public static void process(Node node, int level) {
        for (int i =0; i < level; i++) {
            System.out.print('\t');
        }
        if (node instanceof Element) {
            Element el = (Element) node;
            Text textNode = (Text) el.getFirstChild();
            String str = textNode.getData().trim();
            System.out.print(el.getTagName() + " ");
            System.out.println(str);
        }
    }
}
