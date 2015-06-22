package hw5.users;

//import java.sql.Date;
import java.util.Date;
import java.util.Scanner;

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

    public User addUser(int id){
        this.id = id;
        System.out.println("Введите нового пользователя.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя нового пользователя:");
        name = scanner.nextLine();
        System.out.print("Введите пароль нового пользователя:");
        password = scanner.nextLine();
        return new User(id,name,password,date);
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
