package hw2.authentication;

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
 */
public class Auth {
     private Map<String, String> users;

 public Auth(){
  users = new HashMap<>();
 }

 public boolean authenticate(){
  Scanner scan = new Scanner(System.in);
  System.out.println("Введите логин: ");
  String login = scan.nextLine();
  System.out.println("Введиите пароль: ");
  String pass = scan.nextLine();
    if(authenticate(login,pass)){
     return true;
    }
  return false;
 }

 public boolean authenticate (String login, String pass){
  if (users.containsKey(login)){
   if (users.get(login).equals(pass)){
    return true;
   }
  }
  return  false;
 }

 public void add(String login, String pass) {
  if (users.containsKey(login)){
   System.out.println("Login exist");
   return;
  }
  users.put(login, pass);
 }

 public void remove(String login){
  if (users.containsKey(login)){
   users.remove(login);
  } else{
   System.out.println("Login not found");
  }

 }
}
