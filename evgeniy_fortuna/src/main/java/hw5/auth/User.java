package hw5.auth;

import java.util.Date;

public class User {
    private int userID;
    private String userName;
    private String userPassword;
    private Date userDate;

    User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
    User(String userName, String userPassword, Date userDate) {
        this(userName, userPassword);
        this.userDate = userDate;
    }

    User(int userID, String userName, String userPassword, Date userDate) {
        this(userName, userPassword, userDate);
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Date getUserDate() {
        return userDate;
    }

    public String toString() {
        return "{" + getUserID() + ", " + getUserName()
                + ", " + getUserPassword() + ", " + getUserDate() + "}";
    }
}
