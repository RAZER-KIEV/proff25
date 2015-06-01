package hw2.hash;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 Поля класса пользователь:
 1. Логин
 2. Пароль
 3. Дата регистрации
 4. Рейтинг (вещественное число)
 5. Пол
 Класс задания hw2.hash.User
 */
public class User {
    private String login;
    private String password;
    private Date regDate;
    private double rate;
    private String gender;

    public User(){}

    public User (String login, String password, String regDate, double rate, String gender) throws ParseException {
        this.login = login;
        this.password = password;
        this.regDate = new SimpleDateFormat("dd.MM.yyyy").parse(regDate);
        this.rate = rate;
        this.gender = gender;

    }

    @Override
    public boolean equals(Object obj){

        if (obj instanceof User){
            User tmp = (User) obj;
            if (tmp.hashCode() == this.hashCode()){
                return  true;
            }
        }
        return false;
    }


    @Override
    public int hashCode(){
        return login.hashCode()+password.hashCode()+regDate.hashCode()+gender.hashCode();
    }

}

class Test{
    public static void main(String[] args) throws ParseException {
        User user1 = new User("iuad13ui", "12345", "10.05.2015" ,5.0, "female");
        User user2 = new User("vmis", "55555", "12.03.2015", 4.8, "female");
        User user3 = new User("petya", "try", "23.08.2000",5.0, "male");
        User user4 = new User("petya", "try", "23.08.2000",5.0, "male");


        System.out.println(user1.hashCode());
        if (1690808401 == user1.hashCode()){
            System.out.println("Test done!");
        } else{
            System.out.println("Test false");
        }
        if (user3.equals(user4)){
            System.out.println("Equals: Test done");
        } else {
            System.out.println("Equals: Test fail");
        }

        if (!user1.equals(user2)){
            System.out.println("Equals: Test done");
        } else{
            System.out.println("Equals: Test fail");
        }

    }


}
