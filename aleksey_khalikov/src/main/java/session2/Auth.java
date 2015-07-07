package session2;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by GFalcon on 19.05.15.
 */
public class Auth {
    //private Set<User> users = new HashSet<>();

   // public boolean authent(String log, String pas){

    //    return users.contains(new User(log, pas));
   // }

    public static void main(String[] args) {
        Comparator<User> compPass = new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {
                return o1.getPass().compareTo(o2.getPass());
            }
        };

        TreeSet<User> users = new TreeSet<>(compPass);

        users.add(new User("u5","p1",20));
        users.add(new User("u4","p2",18));
        users.add(new User("u1","p3",2));
        users.add(new User("u2","p4",5));
        users.add(new User("u3","p5",14));

        System.out.println(users.toString());
    }
}

class User implements Comparable<User>{
    private String login;
    private String pass;
    private int outA;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getOut() {
        return outA;
    }

    public void setOut(int out) {
        this.outA = out;
    }

    User(String l, String p){
        login = l;
        pass = p;
        outA = 20;
    }
    User(String l, String p, int o){
        this.login = l;
        this.pass = p;
        this.outA = o;
    }

    @Override
    public int hashCode(){
        return login.hashCode() + pass.hashCode();
    }

    @Override
    public int compareTo(User user){

        return this.getOut() - user.getOut();
    }

    @Override
    public String toString(){
        return getLogin()+" / "+getPass()+" / "+getOut() + " ### ";
    }

}
