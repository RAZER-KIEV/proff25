package homework2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by bosyi on 01.06.15.
 */
public class Auth {

    private HashMap<String, String> userMap;

    public static void main(String[] args) {
        Auth task = new Auth();
        task.add("bosyi","qwerty");
        System.out.println(task.authenticate("bosyi", "qwerty"));
        System.out.println(task.authenticate("bosyi","kjk"));
        System.out.println(task.authenticate("dd","sss"));
    }
    public Auth() {
        userMap = new HashMap<>();
    }

    public boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        String login;
        String password;
        System.out.print("Enter login: ");
        login = scanner.next();
        System.out.print("Enter password: ");
        password = scanner.next();
        boolean isAuth = authenticate(login, password);
        if (isAuth) {
            System.out.println("Ok");
            return isAuth;
        } else {
            System.out.println("Failed");
            return isAuth;
        }
    }

    public boolean authenticate(String login, String password) {
        return userMap.containsKey(login) ? userMap.get(login).equals(password) ? true : false : false;
    }

    public void add(String login, String pass) {
        userMap.put(login, pass);
    }

    public void remove(String login) {
        userMap.remove(login);
    }

}

class AuthTest {

}
