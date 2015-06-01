package Homework2.User;

import java.util.Date;

/**
 * Created by Sveta on 5/29/2015.
 * Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 Поля класса пользователь:
 1. Логин
 2. Пароль
 3. Дата регистрации
 4. Рейтинг (вещественное число)
 5. Пол

 */
public class User implements Comparable<User>{
    String login;
    String password;
    Date registered;
    int rate;
    String sex;

    public User (){

    }
    public User (String login, String password, Date registered, int rate, String sex){
        this.login = login;
        this.password = password;
        this.registered = registered;
        this.rate = rate;
        this.sex = sex;

    }
    @Override
    public int compareTo(User user) {
        if(login.hashCode() > user.login.hashCode()){
        return 1;}
        if(login.hashCode() < user.login.hashCode()){
            return -1;}
        else {
            return 0;
        }
    }
    @Override
    public int hashCode() {

        return login.hashCode() + password.hashCode() + registered.hashCode() + rate + sex.hashCode();
    }
}
class UserTest{
    public static void main(String[] args) {
        User user1 = new User("FirstUser", "Pass1", new Date(24,12,14), 78, "male");
        User user2 = new User("SecondUser", "Pass2", new Date(06,02,15), 86, "female");

        int com = user1.compareTo(user2);
        System.out.println(com);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}