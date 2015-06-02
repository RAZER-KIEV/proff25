package hw2.lab.authentication;

/**
 * Created by ПК on 02.06.2015.
 */
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

/**
 *
 * Написать класс аутентификации пользователя по логину и паролю, с методами:
 - boolean authenticate() - ввод логина и пароля + проверка
 - boolean authenticate(String login, String pass)
 - add(String login, String pass)
 - remove(String login)

 Написать модульный тест.

 Класс задания hw2.authentication.Auth
 Класс теста hw2.authentication.AuthTest
 *
 *
 * Created by ПК on 28.05.2015.
 */
public class Auth {
    Map<String,String> mainHashmap = null;

    public Auth(){
        mainHashmap = new HashMap<String,String>();
    }
    public boolean authenticate(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter login, please: ");
        String tmplogin = in.next();
        System.out.println("Enter password, please: ");
        String tmpPass = in.next();
        return  authenticate(tmplogin,tmpPass);
    }
    public boolean authenticate(String login, String pass) {
        try {
             if (mainHashmap.containsKey(login) && (mainHashmap.get(login).equals(pass))) {
              return true;
             } else return false;}
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public void add(String login, String pass){
        mainHashmap.putIfAbsent(login, pass);
    }
    public void remove(String login){
        mainHashmap.remove(login);

    }
}
//class AuthTest{}