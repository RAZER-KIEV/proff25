package session2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by jul on 28.06.2015.
 */
public class Auth {
    public static void main(String[] args) {
        Auth auth = new Auth();
        System.out.println(auth.authenticate("Kozma", "Prutkov"));
        System.out.println(auth.authenticate("Kozma", "Poroshok"));

        Comparator<User> compPass = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getPassword().compareTo(o2.getPassword());
            }
        };

        TreeSet <User> users = new TreeSet<>(compPass);
        users.add(new User("Kozma", "Prutkov"));
        users.add(new User("Ostap", "Bender"));

        System.out.println(users);
    }
    private Set<User> users = new HashSet<>();

    public Auth() {                                // создаем множество пользователей, т.е. заполняем поля из нашей базы Set
        users.add(new User("Kozma", "Prutkov"));
        users.add(new User("Ostap", "Bender"));
    }

    public boolean authenticate(String login, String pass){
        return users.contains(new User(login,pass));
    }
}

class User implements Comparable<User>{
    private String login;
    private String password;
    private int expireDaysCoount;

    @Override
    public int hashCode() {
        return login.hashCode() + password.hashCode();
    }


    public User (String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (expireDaysCoount != user.expireDaysCoount) return false;
        if (!login.equals(user.login)) return false;
        return password.equals(user.password);
    }

    @Override
    public int compareTo(User user) {
        return user.getLogin().compareTo(getLogin());
    }

    @Override
    public String toString() {
        return "User{" + "login='" + login + '\'' + '}';
    }
}
