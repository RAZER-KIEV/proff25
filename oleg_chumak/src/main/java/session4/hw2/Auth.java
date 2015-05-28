package session4.hw2;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by oleg on 27.05.15.
 */
public  class Auth {

    ArrayList<User> users = new ArrayList<>();

    public void add(String login, String pass){
        users.add(new User(login, pass));
    }

    private User findByLogin(String login ){
        for (User user : users){
            if (user.getLogin().equals(login)) return user;
        }
        return null;
    }

    public void remove(String login){
        User usr = findByLogin(login);
        if (usr == null){
            System.out.println("no user with such login");
        }
        else users.remove(usr);
    }

    public boolean authenticate(String login, String pass){
        User tmp = new User(login,pass);
        for(User usr : users){
            if (usr.equals(tmp)) return true;
        }
        return false;
    }

    public boolean authenticate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert login");
        String login = scan.next();
        System.out.println("Insert password");
        String pass = scan.next();
        return authenticate(login, pass);
    }
}


class User{
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin(){
        return login;
    }

    @Override
    public boolean equals(Object O){
        return (login.equals(((User)O).login) && password.equals(((User)O).password));
    }
}

class main{
    public static void main(String[] args) {
        Auth au = new Auth();
        au.add("oleg", "123");
        au.add("denya", "456");
        au.remove("oleg");
        System.out.println(au.authenticate());
    }
}

class AuthTest{}