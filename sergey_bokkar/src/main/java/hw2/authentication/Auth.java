package hw2.authentication;

import java.util.*;

/**
 * Created by Well on 28.05.2015.
 */
public class Auth {
//    private String login;
//    private String pass;
    private static Map <String, String> users = new HashMap<>();

    public Auth(){};

//    public Auth(String login, String pass){
//        this.login = login;
//        this.pass = pass;
//        hw5.add(login, pass);
//    }.

      // - ввод логина и пароля + проверка
    public static boolean authenticate(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите логин");
        String loginIn = scan.nextLine();

        System.out.println("Введите пароль");
        String passIn = scan.nextLine();

       if(authenticate(loginIn, passIn)){
           System.out.println("Пользователь идентефицирован");
           return true;
       } else {
           System.out.println("Пользователь не найден!");
           return false;
       }
    }

    private static boolean authenticate(String login, String pass){

        for (Map.Entry<String, String> entry : users.entrySet()){

          if (login.contains(entry.getKey()) && pass.contains(entry.getValue())){
            return true;
            }
        }
            return false;
    }

    public static void add(String login, String pass){
        Scanner scan = new Scanner(System.in);

        System.out.println("Добавление нового пользователя");

        if (authenticate(login, pass)){
            System.out.println("Такой Пользователь существует!");
            return;
        }

        users.put(login, pass);
        System.out.println("Пользователь добавлен");


    }

    public static void remove(String login){

        for (Map.Entry<String, String> entry : users.entrySet()){

            if (login.contains(entry.getKey())){
                users.remove(login);
                System.out.println("Пользователь удален из системы");
            }
        }

        System.out.println("Пользователь с таким логином, не найден");
    }


    public static void main(String[] args) {

        users.put("kloun", "123");
        users.put("kolya", "321");
        users.put("chypa", "456");


        authenticate();

        add("vovka", "987");

        add("chypa", "456");

        System.out.println(users);


        remove("chypa");


        System.out.println(users);




    }

}
