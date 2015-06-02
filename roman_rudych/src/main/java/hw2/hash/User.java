package hw2.hash;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rrudych on 27.05.15.
 */
public class User {

    private String login;
    private String password;
    private Date registrationDate;
    private double rating;
    private String sex;

    public User() {

    }

    public User(String login, String password, String ddmmyyyy, Double rating, String sex) throws ParseException, IllegalArgumentException {

        if(!(sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female"))) {
            throw new IllegalArgumentException("sex: " + sex);
        }
        this.login = login;
        this.password = password;
        this.rating = rating;
        this.sex = sex;

        DateFormat sdf = new SimpleDateFormat("dd.mm.yyyyy");

        this.registrationDate = sdf.parse(ddmmyyyy);
    }

    @Override
    public boolean equals(Object object) {
        User user = (User) object;
        return login.equalsIgnoreCase(user.login) &&
                password.equals(user.password) &&
                registrationDate.equals(user.registrationDate) &&
                rating == user.rating &&
                sex.equalsIgnoreCase(user.sex);
    }

    @Override
    public int  hashCode() {
        return login.hashCode() +
                password.hashCode() +
                registrationDate.hashCode() +
                (int) rating +
                sex.hashCode();
    }
}

class UserTest {
    public static void main(String[] args) {
        User user = null;
        User user2 = null;
        User user3 = null;
        try {
            user = new User("Roman", "qwerty", "10.11.2015", 10.5, "male");
            user2 = new User("Ivan", "qwerty", "10.11.2015", 10.5, "male");
            user3 = new User("Ivan", "qwerty", "10.11.2015", 10.5, "male");
        } catch (ParseException except) {
            except.printStackTrace();
        } catch (IllegalArgumentException except) {
            except.printStackTrace();
        }
        System.out.println(user.equals(user2));
        System.out.println(user2.equals(user3));

    }
}