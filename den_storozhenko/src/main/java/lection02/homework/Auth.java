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
        //System.out.println("Print login and password: ");
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

class User1{
    private String login;
    private String password;
    private int time;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getTime() {
        return time;
    }

    User1(String log, String passw, int t){
        login=log;
        password=passw;
        time=t;
    }

    User1(String log, String passw){
        login = log;
        password = passw;
        time = 0;
    }

    @Override
    public boolean equals(Object object){
        if (this==object){
            return true;
        }
        if (object==null){
            return false;
        }
        if (!(object.getClass()==getClass()))
            return false;
        User1 u=(User1)object;
        if (    login!=null &&
                password!=null &&
                u.login.equals(login) &&
                u.password.equals(password) //&&
            //u.time == time
                )
            return true;
        return false;
    }

    @Override
    public int hashCode(){
        return login.hashCode()+password.hashCode();//+time;
    }

    @Override
    public String toString(){
        return "User "+login + ", password "+password+", time "+time+"\n";
    }
}


class AuthTest{
    public static void main(String[] args) {
        Auth auth = new Auth();

    }
}