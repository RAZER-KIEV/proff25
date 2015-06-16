package hw5.auth;

import java.sql.SQLException;

/**
 * Created by oleg on 10.06.15.
 * Написать приложение выполняющее аутентификацию пользователя
 * на основе учётной записи созданнной в предыдущем задании.
 */
public class MainWindow {
    public static void main(String[] args) throws SQLException {
        UserJDBCManager man = new UserJDBCManager();
        man.printUsers();
        System.out.println(man.readByNamePass("Antonina", "aa"));
    }
}
