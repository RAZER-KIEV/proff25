package hw5.auth;

import hw5.users.User;

import java.util.List;

/**
 * Created by roman_rudych on 12.06.15.
 * 2. Аутентификация пользователей
 Написать приложение выполняющее аутентификацию пользователя на основе учётной записи
 созданнной в предыдущем задании. Если пользователь зарегистрирован, то выводим список з
 арегистрированных пользователей, если нет, выводим "Неправильный логин или пароль"

 public int create(User user)
 public List<User> findAll()
 public User readByNamePass(String login, String pass)

 Классы задания:
 hw5.auth.MainWindow
 hw5.auth.UserJDBCManager
 hw5.auth.User
 В класс UserJDBCManager поместите все операции с базой данных. Желательно в методы
 этого класс передовать и возвращать объекты класса User

 public int create(User user)
 public List<User> findAll()
 public User readByNamePass(String login, String pass)
 */
public class MainWindow {
    public static void main(String[] args) {
        UserJDBCManager db = new UserJDBCManager();
        String login = "Roman";
        String password = "pass";
        User user;
        user = db.readByNamePass(login, password);
        if(user == null) {
            System.out.println("Wrong login or password");
        } else {
            List<User> list = db.findAll();
            for(User us : list) {
                System.out.println(us);
            }
        }
    }
}
