package hw5.users;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Віктор on 6/13/2015.
 * 1. Управление пользователями
 * Написать приложение, позволяющее добавлять нового пользователя и просматривать список существующих пользователей. Структура таблицы (id, имя, пароль, дата).
 * <p>
 * Классы задания:
 * hw5.users.MainWindow
 * hw5.users.UserJDBCManager
 * hw5.users.User
 * <p>
 * В класс UserJDBCManager поместите все операции с базой данных. Желательно в методы этого класс передовать и возвращать объекты класса User
 * <p>
 * public int create(User user)
 * public List<User> findAll()
 */
public class User {
    private int id;
    private String name;
    private String password;
    private java.sql.Date date;

    public User(int id, String name, String password, java.sql.Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.date = date;
    }

    public User(int id) {
        addUser(id);
    }

    public User addUser(int id) {
        this.id = id;
        System.out.println("Enter new user:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the new user:");
        name = scanner.nextLine();
        System.out.print("Enter the password of the new user:");
        password = scanner.nextLine();
        return new User(id, name, password, date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }
}
