package main.session2;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by george on 19.05.15.
 */
public class Task2 {
    public static void main(String[] args) {
    Users us = new Users();
//        System.out.println();
        Comparator<User> cmpPass = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getPas().compareTo(o2.getPas());
            }
        };

    }
}

class Users{

    TreeSet<User> users = new TreeSet<User>();
    public Users(){
        users.add(new User("usr","sss",4));
        users.add(new User("usr1","sss",3));
        users.add(new User("usr2","sss",2));
        users.add(new User("usr3","sss",1));
        users.add(new User("usr4","sss",5));
        users.add(new User("usr5","sss",7));
    }
    public User sortUsers(User user){
//        users.
        return user;
    }
}

class User implements Comparable<User>{
    private String login = null;
    private String passwd = null;
    private int expireDaysCount;
    User(String login, String passwd,int expireDaysCount){
        this.login=login;
        this.passwd=passwd;
        this.expireDaysCount = expireDaysCount;
    }

    @Override
    public int hashCode(){
        return login.hashCode()+passwd.hashCode();
    }
    public String getLogin(){
        return login;
    }
    public String getPas(){
        return passwd;
    }
    public int getExpireDaysCount(){
        return expireDaysCount;
    }

    @Override
    public int compareTo(User o) {
        return o.expireDaysCount-expireDaysCount;
    }
    @Override
    public String
    toString(){
        return "o";
    }
}