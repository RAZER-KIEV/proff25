package hw5.auth;

import java.util.Scanner;

/**
 * Created by oleg on 10.06.15.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private java.util.Date date;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public User(int id, String name, String password, java.util.Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.date = date;
    }

    public static User addUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert ID");
        int id = scanner.nextInt();
        System.out.println("Insert your login");
        String name = scanner.next();
        System.out.println("Insert password");
        String password = scanner.next();
        return new User(id, name, password, new java.util.Date());
    }

    @Override
    public String toString(){
        return id+ " " +name+ " " +password+ " " +date.toString();
    }
}
