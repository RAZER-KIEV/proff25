package lection02.homework;

import java.util.Date;

public class User {
    private String login;
    private String password;
    private Date date;
    private double raiting;
    private char sex;

    public User(){

    }

    public User(String login, String password, double raiting, char sex) {
        this.login = login;
        this.password = password;
        this.date = new Date();
        this.raiting = raiting;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object.getClass() == getClass()))
            return false;
        User u = (User) object;
        if (login != null &&
                password != null &&
                date != null &&
                u.login.equals(login) &&
                u.password.equals(password) &&
                u.date.equals(date) &&
                u.raiting == raiting &&
                u.sex == sex
                )
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return login.hashCode() + password.hashCode() + date.hashCode() + Double.hashCode(raiting) + Character.hashCode(sex);//+time;
    }
}
