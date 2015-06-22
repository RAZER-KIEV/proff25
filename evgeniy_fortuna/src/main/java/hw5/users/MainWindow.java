package hw5.users;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//import javax.persistence.Table;
import java.util.List;


/**
 * Написать приложение, позволяющее добавлять нового пользователя и просматривать
 * список существующих пользователей. Структура таблицы (id, имя, пароль, дата).

 Классы задания:
 hw5.users.MainWindow
 hw5.users.UserJDBCManager
 hw5.users.User
 */
public class MainWindow extends Application {
    private Scene scene;
    private TableView<User> table = new TableView<User>();
    private Button selectUser;

    /**Options*/
    private UserJDBCManager db = new UserJDBCManager();

    @Override
    public void init() throws Exception {
        super.init();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        grid.add(new Label("Имя пользователя:"), 0, 1);
        TextField userName;
        grid.add(userName = new TextField(), 1,1);
        grid.add(new Label("Пароль:"), 0, 2);
        TextField userPass;
        grid.add(userPass = new TextField(), 1,2);
        grid.add(new Label("Дата рождения:"), 0, 3);
        TextField userDate;
        grid.add(userDate = new TextField(), 1, 3);
        Button sendNewUser;
        grid.add(sendNewUser = new Button("Добавить нового пользователя"), 0,4,2,1);
        grid.add(selectUser = new Button("Получить данные с БД"), 0,5,2,1);
        table.setEditable(true);
        table.getColumns().addAll(tableColumn("id"), tableColumn("name"), tableColumn("pass"), tableColumn("date"));
        grid.add(table,0, 6, 2, 7);
        selectUser.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                List<User> list = db.findAll();

                ObservableList<User> data = FXCollections.observableArrayList();

                for (int i = 0; i < list.size(); i++) {
                    data.add(list.get(i));
                }
                table.setItems(data);
            }
        });
        scene = new Scene(grid, 480, 700);
    }

    private TableColumn tableColumn(String name) {
        TableColumn tt = new TableColumn(name);
        tt.setMinWidth(100);
        tt.setCellValueFactory( new PropertyValueFactory<>(name));
        return tt;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Управление пользователями");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(700);
        primaryStage.setMaxWidth(800);
        primaryStage.setMaxHeight(900);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}

