package hw5.auth;

import java.sql.Date;

public class User {
    private String name;
    private String password;
    private Date date;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Date  getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(Date date) {
        this.date = date;
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
