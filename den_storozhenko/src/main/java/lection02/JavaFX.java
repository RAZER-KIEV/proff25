package lection02;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.FileInputStream;

/**
 * Created by storo_000 on 26.05.2015.
 */
public class JavaFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //Node rootItem = new ImageView(new Image(new FileInputStream("D:\\Univ\\3\\proff25\\den_storozhenko\\src\\main\\java\\lection01\\homework\\Снимок.PNG")));

        TreeItem<String> root = new CheckBoxTreeItem<>("root");
        TreeView<String> tree = new TreeView<>(root);
        for (int i=0; i<5;i++){
            root.getChildren().add(new TreeItem<>("child"+i));
        }
        root.setExpanded(true);

        BorderPane pane = new BorderPane();
        TextField text = new TextField("text");
        TextArea textArea = new TextArea("1\n2\n");
        pane.setTop(text);
        pane.setCenter(tree);
        pane.setLeft(new Label("PROST TEXT"));
        //pane.setBottom(new Button("OK"));

        Button button = new Button("OK");
        //button.setOnMouseClicked(event -> text.appendText(button.getText()));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //text.appendText(button.getText());
                textArea.appendText(button.getText()+"\n");
            }
        });
        pane.setBottom(button);
        Scene scene = new Scene(pane, 600 ,400);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
    }
}
//Создать приложение
//Окно: текстовое поле, вводится хмл файл, сбоку кнопочка "прочитать"
// после нажатия строится древовидная структура файла хмл