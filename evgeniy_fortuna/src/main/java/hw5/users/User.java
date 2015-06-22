package hw5.users;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Написать приложение, позволяющее добавлять нового пользователя и
 * просматривать список существующих пользователей.
 * Структура таблицы (id, имя, пароль, дата).

 Классы задания:
 hw5.users.MainWindow
 hw5.users.UserJDBCManager
 hw5.users.User

 * В класс UserJDBCManager поместите все операции с базой данных.
 * Желательно в методы этого класс передовать и возвращать объекты класса User

 public int create(User user)
 public List<User> findAll()
 */


public class User {
    private StringProperty id;
    private StringProperty name;
    private StringProperty pass;
    private StringProperty date;

    public User() {}
    public User(String id) {
        this.id = new SimpleStringProperty(id);
    }
    public User(String id, String name) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
    }
    public User(String id, String name, String pass) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.pass = new SimpleStringProperty(pass);
    }
    public User(String id, String name, String pass, String date) {

        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.pass = new SimpleStringProperty(pass);
        this.date = new SimpleStringProperty(date);
    }

    public String getId() { return id.get(); }
    public void setId(String id) {  this.id = new SimpleStringProperty(id);  }

    public String getName() { return name.get(); }
    public void setName(String name) {  this.name = new SimpleStringProperty(name); }

    public String getPass() { return pass.get(); }
    public void setPass(String pass) { this.pass = new SimpleStringProperty(pass); }

    public String getDate() { return date.get(); }
    public void setDate(String date) { this.date = new SimpleStringProperty(date); }

}

