package homeTasks.week2;
import java.util.HashMap;
import java.util.Scanner;

/**
 Написать класс аутентификации пользователя по логину и паролю, с методами:
 - boolean authenticate() - ввод логина и пароля + проверка
 - boolean authenticate(String login, String pass)
 - add(String login, String pass)
 - remove(String login)

 Написать модульный тест.
 Класс задания hw2.authentication.Auth
 Класс теста hw2.authentication.AuthTest
 **/
public class Auth {
    private HashMap<String, String> users = new HashMap<>();

    public void add(String login, String pass){
        users.putIfAbsent(login, pass);
    }
public boolean authenticate(){
    System.out.println("Введите логин");
    Scanner scan = new Scanner(System.in);
    String login = scan.nextLine();
    System.out.println("Введите пароль");
    String pass=scan.nextLine();
    if(users.containsValue(login)&&users.containsKey(pass))return true;
    else return false;
}
public boolean authenticate(String login, String pass){
    if(users.containsValue(login)&&users.containsKey(pass))return true;
    else return false;
}
    public void remove(String login){
        users.remove(login);
    }
    @Override
    public String toString(){
        return users.toString();
    }
    public static void main(String[] args) {
        Auth avtor = new Auth();
        avtor.add("Alex", "a44n73");
        avtor.add("Alena", "a44n74");
        avtor.add("Aletta", "a44n75");
        avtor.add("Alexei", "a44n76");
        avtor.add("Antony", "a44n77");
        System.out.println(avtor.toString());
       // boolean bool =avtor.authenticate();
     //   System.out.println(bool);
     //   System.out.println(avtor.authenticate("Alex", "a44n73"));
        avtor.remove("Alena");
        System.out.println(avtor.toString());
    }
}