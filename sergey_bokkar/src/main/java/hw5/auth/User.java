package hw5.auth;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by Well on 14.06.2015.
 */
public class User {
    private int userId;
    private String name;
    private String pass;
    private SimpleDateFormat dateFormatMain = new SimpleDateFormat("yyyy-MM-dd");
    private String regDate;

    public User (String name, String pass){
        this.name = name;
        this.regDate = dateFormatMain.format(new GregorianCalendar().getTime());
        this.pass = pass;
    }

    public User (int userId, String name, String pass, String regDate) {
        this.userId = userId;
        this.name = name;
        this.regDate = regDate;
        this.pass = pass;
    }


    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getRegDate() {
        return regDate;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return getUserId() + "    " + getName() + "     " + getRegDate();
    }
}

