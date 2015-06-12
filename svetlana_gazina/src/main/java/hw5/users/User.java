package hw5.users;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Sveta on 6/12/2015.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private Date registrationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }





}
