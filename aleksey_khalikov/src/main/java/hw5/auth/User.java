package hw5.auth;

import java.util.Date;

/**
 * Created by GFalcon on 10.06.15.
 */
public class User {
    private Long userId;
    private String name;
    private String pass;
    private Date registrationDate;

    public User(){
        setRegistrationDate(new Date());
    }

    public User(String name, String pass){
        setName(name);
        setPass(pass);
        setRegistrationDate(new Date());
    }

    public User(String id, String name, String pass){
        userId = Long.parseLong(id);
        setName(name);
        setPass(pass);
        setRegistrationDate(new Date());
    }
    public User(Long id, String name, String pass, Date date){
        setUserId(id);
        setName(name);
        setPass(pass);
        setRegistrationDate(date);
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
