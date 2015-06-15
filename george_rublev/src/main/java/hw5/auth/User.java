package hw5.auth;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by george on 11.06.15.
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

    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.date = (java.sql.Date) user.getDate();
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

    public void printUser(User user){
        System.out.println("ID: "+id);
        System.out.println("Login: "+name);
        System.out.println("Password: "+password);
        System.out.println("Date registration: "+date);
    }

}
