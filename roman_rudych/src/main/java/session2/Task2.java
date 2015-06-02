package session2;

import java.util.*;

/**
 * Created by Роман on 19.05.2015.
 */
public class Task2 {
    User us = new User("Roman", "asdwe", 60);
    User us1 = new User("Ivan", "asdwe", 12);
    User us2= new User("Vanya", "asdwe", 14);
    User us3 = new User("Tanya", "asdwe", 8);
    User us4 = new User("Kolya", "asdwe", 19);
    User us5 = new User("Robot", "asdwe", 20);

//    Set<User> users = new HashSet<>();



    Comparator<User> compPass = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.login.compareToIgnoreCase(o2.login);
        }
    };

    SortedSet<User> users = new TreeSet<>(compPass);

    public Task2() {
        users.add(us);
        users.add(us1);
        users.add(us2);
        users.add(us3);
        users.add(us4);
        users.add(us5);
    }

    public static void main(String[] args) {
        Task2 ts = new Task2();
//        System.out.println(ts.AuthCheck("YA", "df"));
//        System.out.println(ts.AuthCheck("Ivan", "asdwe"));

        System.out.println(ts.users);


    }

    public boolean AuthCheck(String login, String pass) {
        return users.contains(new User(login, pass));
    }
}

class User implements Comparable {
    String login;
    String password;
    int days;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, int days) {
        this.login = login;
        this.password = password;
//        super();
        this.days = days;
    }

    @Override
    public boolean equals(Object us) {
        User user = (User) us;
        if(this.login.equals(user.login) && this.password.equals(user.password))
            return true;
        return false;
    }
    @Override
    public int hashCode() {
        return login.hashCode() + password.hashCode();
    }

    @Override
    public int compareTo(Object obj) {
        User o = (User) obj;
//        return this.login.compareToIgnoreCase(o.login);
        return this.days - o.days;

    }
    @Override
    public String toString(){
        return "login = " + login + ", " + days;
    }
}

