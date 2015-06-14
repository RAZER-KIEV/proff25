package hw5.auth;

import java.sql.Date;

public class User {
    String name;
    String password;
    Date  date;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Date  getDate() {
        return date;
    }

    public User(){
        name = password = "";
        date = Date.valueOf("");
    }

    public User(String name, String password, Date date) {
        this.name = name;
        this.password = password;
        this.date = date;
    }

    public void print(){
        System.out.printf("%15s%15s%20tD\n", name, password, date);
    }

}
