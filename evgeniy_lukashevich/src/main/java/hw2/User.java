
package hw2;

import java.util.GregorianCalendar;

/**
 * Created by lukashevich.e on 27.05.2015.
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
    private GregorianCalendar date;
    private double rating;
    private String sex;

    User () {
        this.login = "No name";
        this.password = "1111";
    }

    User (String login, String password) {
        this.login = login;
        this.password = password;
        this.date = new GregorianCalendar(2000, 0, 1);
        this.rating = 0;
        this.sex = "male";
    }

    User (String login, String password, int year, int month, int day, double rating, String sex) {
        this(login, password);
        this.date = new GregorianCalendar(year, month - 1, day);
        this.rating = rating;
        if (sex == "female"){
            this.sex = "female";
        } else {
            this.sex = "male";
        }
    }

    @Override
    public int hashCode() {
        int res = 37;
        res = res*17 + login.hashCode();
        res = res*17 + password.hashCode();
        res = res*17 + date.hashCode();
        res = res*17 + Double.valueOf(rating).hashCode();
        res = res*17 + sex.hashCode();
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (login.equals(user.login)
                && password.equals(user.password)
                && date.equals(user.date)
                && rating == user.rating
                && sex == user.sex) {
            return true;
        }
        return false;
    }

    public static void main (String[] args) {

        User user1 = new User("Rob", "1230h", 1995, 2, 24, 3.145, "male");
        User user2 = new User("Rob", "1230h", 1995, 2, 24, 3.14, "male");

        System.out.println(user1.equals(user2));
        System.out.println(user1.hashCode() == user2.hashCode());

    }
}

class UserTest {

}