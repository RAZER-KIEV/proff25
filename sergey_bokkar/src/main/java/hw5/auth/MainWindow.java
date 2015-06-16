package hw5.auth;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Well on 14.06.2015.
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

        Button btnAuth = new Button();
        btnAuth.setText("Аутентификация");
        btnAuth.setPrefSize(150, 35);
        btnAuth.setLayoutX(100);
        btnAuth.setLayoutY(70);
        root.getChildren().add(btnAuth);

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


        btnAuth.setOnMouseClicked(event -> {
            UserJDBCManager userManager = new UserJDBCManager();
            User user = null;
            user = userManager.readByNamePass(textFieldName.getText(), textFieldSurmane.getText());
            if (user != null) {
                UserJDBCManager userManagerView = new UserJDBCManager();
            for (User userView : userManagerView.findAll())
                mainArea.setText(mainArea.getText() + "\n" + userView.toString());
            } else {
                mainArea.setText(mainArea.getText() + "\n" + "Неверный логин или пароль");
            }
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

