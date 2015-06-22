package hw5.users;

import java.sql.SQLException;

/**
 * Написать приложение, позволяющее добавлять нового пользователя и просматривать
 * список существующих пользователей. Структура таблицы (id, имя, пароль, дата).
 * Классы задания:
 * hw5.hw5.MainWindow
 * hw5.hw5.UserJDBCManager
 * hw5.hw5.User
 * В класс UserJDBCManager поместите все операции с базой данных.
 * Желательно в методы этого класс передовать и возвращать объекты класса User
 * public int create(User user)
 * public List<User> findAll()
 *
 *  Created by george on 11.06.15.
 */

public class MainWindow{

    public static void main(String[] args) {

        try {
            UserJDBCManager users = new UserJDBCManager();
            users.printUsers();
//            User us = new User(hw5.getNextId());
//            System.out.println(us.getId());
//            System.out.println(us.getName());
//            System.out.println(us.getPassword());
//            System.out.println(us.getDate());
            users.addUser(new User(users.getNextId()));
            users.printUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
