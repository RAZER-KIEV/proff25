package hw2;

/**
 * Created by GFalcon on 30.05.15.
 * Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 Поля класса пользователь:
 1. Логин
 2. Пароль
 3. Дата регистрации
 4. Рейтинг (вещественное число)
 5. Пол

 Класс задания hw2.hash.User
 */
public class hash {
}
class User{
    private String loggin;
    private String password;
    private long date;
    private double score;
    private boolean man;

    User(){
        this("User", "password", 19000101, 0.0, true);
    }
    User(String log, String pas, long d, double sc, boolean s){
        loggin = log;
        password = pas;
        date = d;
        score = sc;
        man = s;
    }

    @Override
    public boolean equals(Object us){
        User user2 = (User) us;
        if (this.loggin.equals(user2.loggin)
                && this.password.equals(user2.password)
                && this.date == user2.date
                && this.score == user2.score
                && this.man == user2.man){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        int code;
        code = (this.loggin.hashCode() + this.password.hashCode())*((int)(this.date + this.score * 100));
        if (this.man = false){
            code = -code;
        }
        return code;
    }
}