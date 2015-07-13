package hw5.users;

import java.sql.SQLException;

/**
 * Created by roman_rudych on 11.06.2015.
 * 1. Управление пользователями
 Написать приложение, позволяющее добавлять
 нового пользователя и просматривать список существующих
 пользователей. Структура таблицы (id, имя, пароль, дата).
 Классы задания:
 hw5.hw5.MainWindow
 hw5.hw5.UserJDBCManager
 hw5.hw5.User

 В класс UserJDBCManager поместите все операции с базой данных.
 Желательно в методы этого класс передовать и возвращать объекты класса User

 public int create(User user)
 public List<User> findAll()
 */
public class MainWindow{
    public static void main(String[] args) {
        UserJDBCManager db = new UserJDBCManager();

        try {
            User us1 = new User("Roman", "pass", "12-may-12");
            User us2 = new User("Ivan", "pass", "12-dec-15");
            User us3 = new User("Kolya", "pass", "12-may-12");
            User us4 = new User("Rabert", "pass", "16-jun-10");
            User us5 = new User("Valion", "pass", "12-aug-12");

            db.create(us1);
            db.create(us2);
            db.create(us3);
            db.create(us4);
            db.create(us5);

            System.out.println(db.findAll());

        } catch (SQLException except) {
            except.printStackTrace();
            System.out.println("Connection problem");
        }

    }
}
