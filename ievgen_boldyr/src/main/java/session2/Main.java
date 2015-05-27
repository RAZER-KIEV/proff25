package session2;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by nucleos on 19.05.15.
 */
public class Main {

    public static void main(String[] args) {
        Set<User> users = new TreeSet<User>(new UsersByDays());
        users.add(new User("test1", "test1", 5));
        users.add(new User("test3", "test4", 3));
        users.add(new User("test2", "test3", 4));
        users.add(new User("test4", "test5", 2));
        users.add(new User("test5", "test2", 1));

        System.out.println(users);
    }
}
