package hw5.auth;

import java.util.Date;

/**
 * Created by ivan on 24.07.15.
 *
 */

public class User {

    private int id;

    private String name;

    private String password;

    private Date date;

    public User() {
        this(99, "User", "password", new Date(System.currentTimeMillis()));
    }

    public User(int id, String name, String password, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.date = date;
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

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new String("User name: " + name + ", id: " + id + ", creation date: " + date + ".");
    }

}
