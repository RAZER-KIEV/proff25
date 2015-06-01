package Homework2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by just1ce on 29.05.2015.
 */
public class Auth {
    Map data;
    public Auth(){
        data= new HashMap< String, String>();
    }
    public boolean authenticate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter login");
        String login = scan.next();
        System.out.println("Enter password");
        String pass = scan.next();
        return authenticate(login, pass);
    }
    public boolean authenticate(String login, String pass){
        return (data.containsKey(login)&&(data.get(login).equals(pass)));
    }
    boolean add(String login, String pass){
        if (data.containsKey(login)) return false;
        data.put(login,pass);
        return true;
    }
    boolean remove(String login){
        if (!data.containsKey(login)) return false;
        data.remove(login);
        return true;
    }
}
class AuthTest{
    Auth server= new Auth();
    boolean test(){
        server.add("ivan","123");
        server.add("ivan1","1234");
        server.add("ivan2", "12345");
        System.out.println(server.authenticate());
        System.out.println(server.authenticate("ivan2","12345"));
        System.out.println(server.authenticate("ivan5", "12345"));
        System.out.println(server.remove("ivan2"));
        System.out.println(server.authenticate("ivan2", "12345"));
        return true;
    }
}