package hw2.user;

/**
 * Created by Well on 28.05.2015.
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
    private String pass;
    private int regDate;
    private int rate;
    private int sex;

    public User (){};

    public User (String login, String pass, int regDate, int rate, int sex){
        this.login = login;
        this.pass = pass;
        this.regDate = regDate;
        this.rate = rate;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return login.hashCode() + pass.hashCode();
    }

}
