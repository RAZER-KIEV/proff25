package lection02.homework;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by storo_000 on 28.05.2015.
 */
public class Auth {
    private HashSet<User1> set;

    public Auth(){
        set = new HashSet<>();
    }

    public HashSet<User1> getSet(){
        return set;
    }

    public boolean authenticate(){
        Scanner scanner = new Scanner(System.in);
        String log = scanner.next();
        String passw = scanner.next();
        return (set.contains(new User1(log,passw)));
    }

    public boolean authenticate(String log, String passw){
        return (set.contains(new User1(log,passw)));
    }

    public  void add(String login, String pass){
        set.add(new User1(login,pass));
    }

    public void remove(String login){
        for (User1 user1:set){
            if (user1.getLogin().equals(login))
            {
                set.remove(user1);
                return;
            }
        }
    }
}

