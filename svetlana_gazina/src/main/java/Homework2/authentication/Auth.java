package Homework2.authentication;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Sveta on 5/29/2015.
 * Написать класс аутентификации пользователя по логину и паролю, с методами:
 - boolean authenticate() - ввод логина и пароля + проверка
 - boolean authenticate(String login, String pass)
 - add(String login, String pass)
 - remove(String login)

 Написать модульный тест.

 Класс задания hw2.authentication.Auth
 Класс теста hw2.authentication.AuthTest
 */
public class Auth {
    String login;
    String password;
    HashMap<String, String> users = new HashMap<>();


    Scanner scanner = new Scanner(System.in);
    public boolean authenticate(){
        System.out.println("Enter your login: ");
        login = scanner.next();
        System.out.println("Enter your password: ");
        password = scanner.next();
        return authenticate(login, password);
    }
    public boolean authenticate(String login, String pass) {
        if(users.containsKey(login) && users.get(login).equals(pass)){
            return true;
        }
        return  false;
    }
    public  void add(String login, String pass){
        if(users.containsKey(login)){
            System.out.println("User already exists!");
        }
        else {
            users.put(login, pass);
        }
    }
    public void remove(String login){
        if(users.containsKey(login)){
            users.remove(login);
        }

    }
}
class  AuthTest {
    public static void main(String[] args) {
        Auth auth = new Auth();
        auth.add("First", "pass1");
        System.out.println(auth.users + " : should be: First, pass1");
        System.out.println(auth.authenticate("First", "pass1") + ":  true");
        System.out.println(auth.authenticate("First", "pass") + ":  false");
        System.out.println(auth.authenticate("Fi", "pass1") + ":  false");


        System.out.println(auth.authenticate() + ":  " + auth.users);

        auth.add("Second", "pass2");
        System.out.println(auth.users + " : should be: First, pass1 and Second, pass2");

        auth.remove("First");
        System.out.println(auth.users + " : should be: Second, pass2");


    }

}