package hw2.authentication;

import java.util.HashMap;

/**
 * Created by viktoria
 */
public class AuthTest {

    public static void main(String[] args) {
       Auth users = new Auth();
        users.add("iuad13", "qaz");
        users.add("login", "pass");
        users.add("login", "wer");
        System.out.println(users.authenticate());
    }
}
