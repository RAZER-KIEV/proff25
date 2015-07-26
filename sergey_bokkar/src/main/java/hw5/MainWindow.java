package hw5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Well on 10.06.2015.
 * графика
 */
public class MainWindow extends Application {
    private TextArea mainArea;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTGREY);

        Button btnAdd = new Button();
        Button btnView = new Button();
        btnAdd.setText("Добавить пользователя");
        btnView.setText("Список пользователей");
        btnAdd.setPrefSize(150, 35);
        btnView.setPrefSize(150, 35);
        btnAdd.setLayoutX(100);
        btnAdd.setLayoutY(70);
        btnView.setLayoutX(270);
        btnView.setLayoutY(70);
        root.getChildren().add(btnAdd);
        root.getChildren().add(btnView);

        TextField textFieldName = new TextField();
        textFieldName.setPrefSize(300, 35);
        textFieldName.setLayoutX(30);
        textFieldName.setLayoutY(25);
        root.getChildren().add(textFieldName);

        TextField textFieldSurmane = new TextField();
        textFieldSurmane.setPrefSize(300, 35);
        textFieldSurmane.setLayoutX(360);
        textFieldSurmane.setLayoutY(25);
        root.getChildren().add(textFieldSurmane);


        btnView.setOnMouseClicked(event -> {
            mainArea.clear();
            UserJDBCManager userManager = new UserJDBCManager();
            for (User user : userManager.findAll())
                mainArea.setText(mainArea.getText() + "\n" + user.toString());

        });

        btnAdd.setOnMouseClicked(event -> {
            UserJDBCManager userManager = new UserJDBCManager();
            User user = new User(textFieldName.getText(), textFieldSurmane.getText());
            userManager.create(user);
            textFieldName.clear();
            textFieldSurmane.clear();
        });

        mainArea = new TextArea();
        mainArea.setPrefSize(760, 450);
        mainArea.setLayoutX(20);
        mainArea.setLayoutY(120);
        root.getChildren().add(mainArea);

        stage.setTitle("Main Window");
        stage.setScene(scene);
        stage.show();
    }
}
