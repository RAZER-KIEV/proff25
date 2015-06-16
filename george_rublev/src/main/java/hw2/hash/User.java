package hw2.hash;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created by George on 28.05.15.
 */
class UserTest {
    public static void main(String[] args) {


    }
}
public class User{

    public static final boolean MAN = true;
    public static final boolean WOMAN = false;

    private String login;
    private String password;
    private Date bithday;
    private int rate;
    private boolean sex;

    public User() throws ParseException {
        this("George","1234","05.05.1983",1,MAN);
    }

    public User(String login, String password, String ddmmyyyy, int rate, boolean sex) throws ParseException {
        this.login=login;
        this.password=password;
        DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
        this.bithday=df.parse(ddmmyyyy);
        this.rate=rate;
        this.sex=sex;
    }

    @Override
    public boolean equals(Object o){
        User temp = (User) o;
        return login.equals(temp.login)
                && password.equals(temp.password)
                && bithday==temp.bithday
                && rate==temp.rate
                && sex==temp.sex;
    }
    @Override
    public int hashCode(){

        final int prime = 31;
        int result = prime * login.hashCode()+prime*password.hashCode()+bithday.hashCode()+rate;
        if (sex==MAN){
            result+=2;
        }
        else if (sex==WOMAN){
            result+=1;
        }

        return result;
    }
}