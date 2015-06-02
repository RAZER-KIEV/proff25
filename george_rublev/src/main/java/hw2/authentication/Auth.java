package hw2.authentication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by george on 28.05.15.
 */
public class Auth {
    Map<String, String> auth = new HashMap<>();

    Auth(){
        auth.put("George", "7654321");
        add("Dade","qwerty");
    }

    public boolean authenticate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("password:");
        String pass = scanner.nextLine();
        return check(login,pass);
    }

    public boolean authenticate(String login, String pass){
        return check(login,pass);
    }

    public boolean check(String login, String pass){
        String pas = auth.get(login);
        if(auth.get(login)==null) System.out.println("login not find");
        return auth.get(login)!=null && pas.equals(pass);
    }


    public boolean add(String login, String pass){

        if(auth.get(login)==null){
            auth.put(login,pass);
            System.out.println("add login: "+ login+"  pasword: "+pass );
            return true;
        }
        return false;
    }

    public boolean remove(String login){
        if(auth.get(login)==null){
            System.out.println("login not find");
            return false;
        }

            auth.remove(login);
            System.out.println("login deleted");
            return true;


    }
}

class AuthTest{



    public static void main(String[]args){
            Auth auth = new Auth();
            System.out.println(auth.authenticate());
            System.out.println(auth.remove("Dade"));

            System.out.println(auth.authenticate());
            }
}
