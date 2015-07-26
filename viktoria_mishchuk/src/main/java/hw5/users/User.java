package hw5.users;

import java.util.Date;

/**
 * Created by viktoria
 * Project:.hw5.users
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private Date date;

    public User(){

    }

    public User (int id, String userName, String password, Date date){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.date = date;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
