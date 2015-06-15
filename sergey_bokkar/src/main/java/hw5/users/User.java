package hw5.users;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Well on 10.06.2015.
 * модельюзера
 */
public class User {
    private int userId;
    private String name;
    private String pass;
    private SimpleDateFormat dateFormatMain = new SimpleDateFormat("yyyy-MM-dd");
    private String regDate;
//    private Date regDate;
//    static int idCount = 0;



    public User (String name, String pass){
//        this.userId = ++idCount;
        this.name = name;
//        this.regDate = new GregorianCalendar().getTime();
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
}
