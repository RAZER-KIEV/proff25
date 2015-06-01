package hw2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by GFalcon on 30.05.15.
 * Написать класс аутентификации пользователя по логину и паролю, с методами:
 - boolean authenticate() - ввод логина и пароля + проверка
 - boolean authenticate(String login, String pass)
 - add(String login, String pass)
 - remove(String login)
 */
public class authentication {

}

class Auth {
    private HashMap<String, String> userList;

    public boolean authrnticate(){
        Scanner str = new Scanner(System.in);
        System.out.println("Enter your login:");
        String login = str.nextLine();
        System.out.println("Enter your password:");
        String pass = str.nextLine();
        return userList.containsKey(login) & userList.containsValue(pass);
    }

    public boolean authenticate(String login, String pass){
        return userList.containsKey(login) & userList.containsValue(pass);
    }

    public void add(String login, String pass){
        userList.putIfAbsent(login, pass);
    }

    public void remove(String login){
        userList.remove(login);
    }

}

class AuthTest {

}
