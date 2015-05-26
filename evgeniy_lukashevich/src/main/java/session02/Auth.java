
package session02;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Jeckgehor on 19.05.2015.
 */
class User implements Comparable<User> {

    private String login;
    private String password;
    private int time;

    public User (String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User (String login, String password, int time) {
        this(login, password);
        this.time = time;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int hashCode(){
        return  login.hashCode() + password.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if(login.equals(user.getLogin()) && password.equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(User user) {
        return  login.compareTo(user.login);
    }

    @Override
    public String toString() {
        return "User: " + login + "; Password: " + password;
    }
}

public class Auth {

    private Set<User> users = new TreeSet<>(new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            if(user1.getTime() > user2.getTime()) {
                return 1;
            } else if (user1.getTime() == user2.getTime()) {
                return user1.getPassword().compareTo(user2.getPassword());
            } else {
                return -1;
            }
        }
    });

    public Auth() {
        users.add(new User("Ivan", "2YGjJhGF"));
        users.add(new User("Mark", "GHImnbG", 17));
        users.add(new User("Rick", "QEHhGj", 44));
        users.add(new User("Bill", "BHhGkjp", 5));
        users.add(new User("Tomb", "0GHvYTVFu", 12));
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        for (User el : users) {
            stb.append(el.toString() + "\n");
        }
        return stb.toString();
    }

    public boolean authenticate (String log, String pass) {
        return users.contains(new User(log, pass));
    }

    public static void main (String[] args) {
        Auth auth = new Auth();
        System.out.println(auth.authenticate("Ivan", "2YGjJhGF"));
        System.out.println(auth.authenticate("Genry", "GHvYTVFu"));
        System.out.println(auth);
    }
}