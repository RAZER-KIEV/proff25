package session2;

import java.util.*;

/**
 * Created by ivan on 19.05.15.
 */

class Auth {
    static TreeSet<Usr> usrTreeSet = new TreeSet<Usr>(){
        @Override
        public boolean add(Usr usr) {
            if(usrTreeSet.contains(usr)){
                return false;
            } else {
              return  super.add(usr);
            }
        }

        @Override
        public boolean contains(Object o) {
//                if() {
//                    return true;
//                }
            return super.contains(o);
        }
    };

//    static HashSet<Usr> usrHashSet = new HashSet<Usr>();

    static boolean islogged(Usr usr) {
        return Auth.usrTreeSet.contains(usr);
    }

}

public class Usr implements Comparable {


    Usr(String login, String password, int timeLeft) {
        this.login = login;
        this.password = password;
        this.timeLeft = timeLeft;
        Auth.usrTreeSet.add(this);
    }
    private String login;
    private String password;
    private int timeLeft;

    @Override
    public int hashCode() {
        //int random = (int)Double.doubleToLongBits(Math.random());
        int random = 10;
        int hashcode = login.hashCode() * password.hashCode() * random;
        return hashcode;
    }

    int getTimeLeft() {
        return timeLeft;
    }

    @Override
    public int compareTo(Object o) {
        Usr u = (Usr) o;
        return this.getTimeLeft() - u.getTimeLeft();
    }

    @Override
    public String toString() {
        return new String("Login: "+login+"; timeLeft: "+timeLeft+".");
    }

    public static void printUsers(){
        Iterator<Usr> iter = Auth.usrTreeSet.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }

    public static Comparator<Usr> compareByLogin = new Comparator<Usr>() {
        @Override
        public int compare(Usr u1, Usr u2) {
            return u1.login.compareTo(u2.login);
        }
    };

    public static void main(String[] args) {
        Usr u1 = new Usr("ivan", "123", 15);
        Usr u2 = new Usr("misha", "124", 10);
        Usr u3 = new Usr("ivan", "123", 2);
        Usr u4 = new Usr("kolja", "123", 4);
        Usr u5 = new Usr("sasha", "1234", 6);
        printUsers();
    }
}

//*Сделать отдельный класс аутентиф., который и хранит базу пользователей.