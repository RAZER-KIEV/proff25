package session2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by bosyi on 19.05.15.
 */
public class SetEx {

    private static Set<User> users = new HashSet<>();
    private static Set<User> usersTree = new TreeSet<>();

    public static void main(String[] args) {

        /*users.add(new User("bosyi","qwerty",30));
        users.add(new User("name","qwerty1",15));
        users.add(new User("killer","qwefdrty",30));
        users.add(new User("master","qwerty_111",60));
        users.add(new User("bosyi1","qweqwe",15));

        System.out.println(isAutenticated("bosyi", "qwerty"));
        System.out.println(isAutenticated("fewfew","dewdw"));*/

        usersTree.add(new User("bosyi","qwerty",30));
        usersTree.add(new User("name","qwerty1",15));
        usersTree.add(new User("killer","qwefdrty",30));
        usersTree.add(new User("master","qwerty_111",60));
        usersTree.add(new User("bosyi1","qweqwe",15));

        Comparator<User> comPass = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return 0;
            }
        };
        TreeSet<User> user22 = new TreeSet<>(comPass);

        System.out.println(usersTree);

    }

    public static boolean isAutenticated(String login, String password) {
        User user = new User(login, password);
        int usHashCode = user.hashCode();
        for (User u:users) {
            if (u.hashCode() == usHashCode) {
                return true;
            }
        }
        return false;
    }

}
