package session2;

/**
 * Created by bosyi on 19.05.15.
 */
public class User implements Comparable<User> {

    private String login;
    private String password;
    private int daysAvailable;

    public User(String login, String password) {
        this(login, password, 15);
    }

    public User(String login, String password, int daysAvailable) {
        this.login = login;
        this.password = password;
        this.daysAvailable = daysAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (login != null
                && password != null
                && login.equals(user.login)
                && password.equals(user.password)
                && daysAvailable == user.daysAvailable) {
            // end of
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return login.hashCode() + password.hashCode();
    }

    @Override
    public int compareTo(User user) {
        if (user.daysAvailable < daysAvailable) {
            return 1;
        } else if (user.daysAvailable > daysAvailable) {
            return -1;
        } else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return "User: " + login + ";Days Avl: " + daysAvailable;
    }
}
