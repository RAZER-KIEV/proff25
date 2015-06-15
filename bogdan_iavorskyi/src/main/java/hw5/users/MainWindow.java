package hw5.users;

import java.sql.SQLException;
import java.util.List;

/*
 * Написать приложение, позволяющее добавлять нового пользователя
 * и просматривать список существующих пользователей.
 * Структура таблицы (id, имя, пароль, дата).
 */
public class MainWindow {
    public static void main(String[] args) throws SQLException {
        UserJDBCManager userJDBCManager = new UserJDBCManager();
        userJDBCManager.openConnection();
        userJDBCManager.printUsers();
        userJDBCManager.remove("testlogin");
        userJDBCManager.printUsers();
        userJDBCManager.closeConnection();
    }
}
