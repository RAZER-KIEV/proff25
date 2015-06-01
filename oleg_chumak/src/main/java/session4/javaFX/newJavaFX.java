package session4.javaFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by oleg on 26.05.15.
 */
public class newJavaFX extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        TextField text = new TextField("enter here your XML");
        pane.setCenter(text);
        Button button = new Button("draw");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("/home/oleg/IdeaProjects/proff25/oleg_chumak/Group"));
            Element rootEl = doc.getDocumentElement();
//            System.out.println(rootEl.getTextContent());
//            print(rootEl);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        TreeItem root = new CheckBoxTreeItem<>("root");
        TreeView tree = new TreeView(root);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                textField.appendText(button.getText());
            }
        });
        pane.setRight(button);
        pane.setCenter(tree);

        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }
}
