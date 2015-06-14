package hw5.auth;


/**
 * Created by Роман on 11.06.2015.
 */
public class User {

    private String userName;
    private String userPassword;
    private String userDate;

    public User(String userName, String userPassword, String userDate_DD_MMM_YY) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userDate = userDate_DD_MMM_YY;
    }

    public String getName() {
        return userName;
    }

    public String getPassword() {
        return userPassword;
    }

    public String getDate() {
        return userDate;
    }

    public String toString() {
        return userName + " " + userPassword + " " + userDate;
    }
}
