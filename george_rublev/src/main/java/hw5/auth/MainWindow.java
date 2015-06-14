package hw5.auth;

import java.sql.SQLException;

/**
 * Написать приложение выполняющее аутентификацию пользователя на основе учётной записи созданнной в предыдущем задании. Если пользователь зарегистрирован, то выводим список зарегистрированных пользователей, если нет, выводим "Неправильный логин или пароль"
 public int create(User user)
 public List<User> findAll()
 public User readByNamePass(String login, String pass)

 Классы задания:
 hw5.auth.MainWindow
 hw5.auth.UserJDBCManager
 hw5.auth.User
 * Created by george on 11.06.15.
 */
public class MainWindow {
    public static void main(String[] args) {
        UserJDBCManager man = null;
        try {
            man = new UserJDBCManager();
            man.printUsers();
            User us = new User(man.readByNamePass("George","555"));
            us.printUser(us);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
