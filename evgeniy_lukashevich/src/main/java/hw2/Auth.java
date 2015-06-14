package hw2;

import java.util.HashMap;
import java.util.Scanner;

/**Написать класс аутентификации пользователя по логину и паролю, с методами:
 - boolean authenticate() - ввод логина и пароля + проверка
 - boolean authenticate(String login, String pass) - проверка по данным, переданным как аргументы в метод
 - add(String login, String pass) - добавление пользователя
 - remove(String login) - удаление пользователя

 Написать модульный тест.

 Класс задания hw2.authentication.Auth
 Класс теста hw2.authentication.AuthTest
 * Created by lukashevich.e on 28.05.2015.
 */
public class Auth {

    private HashMap<String, String> hashMap;

    Auth(){
        hashMap = new HashMap<String, String>();
    }

    public static void main (String[] args) {
        Auth auth = new Auth();
        auth.add("Omen", "11111");
        auth.add("Jeck", "54184");
        auth.add("Mark", "54130");
        auth.add("David", "78060");
        auth.add("Urban", "96024");
        auth.remove("Omen");
        System.out.println(auth.hashMap);
        System.out.println(auth.authenticate("Urban", "96024"));
        System.out.println(auth.authenticate());
    }

    public boolean add(String login, String pass){
        if (hashMap.containsKey(login)) {
            return false;
        } else {
            hashMap.put(login, pass);
            return true;
        }
    }

    public boolean remove (String login){
        if (hashMap.containsKey(login)) {
            hashMap.remove(login);
            return true;
        } else {
            return false;
        }
    }

    public boolean authenticate(String login, String pass){
        if (hashMap.containsKey(login)) {
            if (hashMap.containsValue(pass)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public boolean authenticate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your login");
        String loginUser = sc.next();
        System.out.println("Enter your password");
        String passUser = sc.next();
        if (hashMap.containsKey(loginUser)) {
            if (hashMap.containsValue(passUser)) {
                return true;
            }
        }
        return false;
    }
}

class AuthTest{

}