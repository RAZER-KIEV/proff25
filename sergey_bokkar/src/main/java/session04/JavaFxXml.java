package session04;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * Created by Well on 26.05.2015.
 */
public class JavaFxXml {
    public static void main(String[] args) {
        BorderPane pane = new BorderPane();
        TextField text = new TextField("text");
        pane.setTop(new TextField("text"));
        pane.setCenter(new TextField("text"));
    }
}
