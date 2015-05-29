package session2.Session2_2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by oleg on 19.05.15.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Comparator<User> compPass = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return (o1.getPassword().compareTo(o2.getPassword()));
            }
        };
        TreeSet<User> set = new TreeSet<>(compPass);
        set.add(new User("one", "a", 3));
        set.add(new User("two", "h", 4));
        set.add(new User("three", "s", 7));
        set.add(new User("four", "azabfza", 1));
        set.add(new User("five", "azazasdfa", 6));
        System.out.println(set);
        System.out.println(main.authenticate("one", "azaza"));
        System.out.println(main.authenticate("dfsa", "gdss"));
        System.out.println(main.authenticate("dfsa", "gdss"));
    }

    private Set<User> users = new HashSet<>();

    public Main() {

        users.add(new User("one", "azaza"));
        users.add(new User("two", "ajaja"));
        users.add(new User("one", "azaza"));

    }

    public boolean authenticate(String login, String pass) {
        return users.contains(new User(login, pass));
    }
}