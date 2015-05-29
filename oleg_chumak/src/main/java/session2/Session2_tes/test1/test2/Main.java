package session2.Session2_tes.test1.test2;


import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by oleg on 20.05.15.
 */
public class Main {
    public static void main(String[] args) {
//        Main main = new Main();
//        System.out.println(main.log("fgs", "gsdfgg"));
//        System.out.println(main.log("odin", "pfds"));
        Comparator<User> comPass = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getPassword().compareTo(o2.getPassword());
            }
        };
        TreeSet<User> set = new TreeSet<>(comPass);
        set.add(new User("a", "zzz"));
        set.add(new User("c", "hhh"));
        set.add(new User("b", "gsdfg"));
        System.out.println(set.toString());
    }
    HashSet<User> users = new HashSet<>();

    public Main(){
        users.add(new User("odin", "pfds"));
        users.add(new User("dva", "gfds"));
        users.add(new User("tri", "ghsuu"));
    }

    private boolean log(String login, String pas){
        return users.contains(new User(login, pas));
    }
}
