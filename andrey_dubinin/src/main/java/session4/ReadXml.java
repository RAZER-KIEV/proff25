package session4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.json.XML;

/**
 * Created by jax on 26.05.15.
 */
public class ReadXml extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Label(),500,500);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }
}
