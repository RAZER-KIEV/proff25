package hw2.hash.authentication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Написать класс аутентификации пользователя по логину и паролю, с методами:
 - boolean authenticate() - ввод логина и пароля + проверка
 - boolean authenticate(String login, String pass)
 - add(String login, String pass)
 - remove(String login)

 Написать модульный тест.

 Класс задания hw2.authentication.Auth
 Класс теста hw2.authentication.AuthTest

 * Created by rrudych on 27.05.15.
 */
public class Auth {

//    String login;
//    String password;
    Map<String, String> hashMap = new HashMap<>();

    public Auth() {   }


    public Auth(Map<String, String> userData) {
        this.hashMap = userData;
    }

    public boolean authenticate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter user login:");
        String login = scan.nextLine();
        System.out.println("Enter user password:");
        String password = scan.nextLine();
        if(!hashMap.containsKey(login)) {
            return false;
        }
        if(hashMap.get(login).equals(password)) {
            return true;
        }
        return false;
    }

    public boolean authenticate(String login, String pass) {
        if(!hashMap.containsKey(login)) {
            return false;
        }
        if(hashMap.get(login).equals(pass)) {
            return true;
        }
        return false;

    }

    public void add(String login, String pass) {

        hashMap.put(login, pass);
    }

    public void remove(String login) {
        hashMap.remove(login);

    }
}
class AuthTest {
    public static void main(String[] args) {
        Auth auth = new Auth();
        auth.add("Roman", "qwerty");
        System.out.println(auth.authenticate("Roman", "qwerty"));
        System.out.println(auth.authenticate());
    }
}