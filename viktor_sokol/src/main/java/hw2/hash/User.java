package hw2.hash;

import java.util.Date;

/**
 * Created by Віктор on 8/6/2015.
 *
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
    private String name;
    private String password;
    private Date dateReg;
    private int rating;
    private int sex; //man-0; woman - 1.

    public User(){
        
    }
    public User(String name, String password, Date dateReg, int rating, int sex){
        this.name = name;
        this.password = password;
        this.dateReg = dateReg;
        this.rating = rating;
        this.sex = sex;
    }
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        User user = (User) obj;

        if (name != user.name) return false;
        if (password != user.password) return false;
        if (dateReg != user.dateReg) return false;
        if (rating != user.rating) return false;
        if (sex != user.sex) return false;
        return password.equals(user.password);

    }
}
