package session2;

/**
 * Created by nucleos on 19.05.15.
 */

public class User implements Comparable<User> {

    private String login;
    private String password;
    private Integer days;

    public User(String login, String password, Integer days) {
        this.login = login;
        this.password = password;
        this.days = days;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Integer getDays() {
        return days;
    }

    @Override
    public int compareTo(User user) {
        if (days.compareTo(user.getDays()) > 0) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return login + " " + password + " " + days;
    }
}
