package lection02.homework;

import java.util.Random;

/**
 * Created by Lapchenko on 02.06.2015.
 */
public class User1{
    private String login;
    private String password;
    private int time;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getTime() {
        return time;
    }

    public User1(String log, String passw, int t){
        login=log;
        password=passw;
        time=t;
    }

    public User1(String log){
        login = log;
        Random r = new Random();
        password = Integer.toString(r.nextInt());
        time = 0;
    }

    public User1(String log, String passw){
        login = log;
        password = passw;
        time = 0;
    }

    @Override
    public boolean equals(Object object){
        if (this==object){
            return true;
        }
        if (object==null){
            return false;
        }
        if (!(object.getClass()==getClass()))
            return false;
        User1 u=(User1)object;
        if (    login!=null &&
                password!=null &&
                u.login.equals(login) &&
                u.password.equals(password)
                )
            return true;
        return false;
    }

    @Override
    public int hashCode(){
        return login.hashCode()+password.hashCode();//+time;
    }

    @Override
    public String toString(){
        return "User "+login + ", password "+password+", time "+time+"\n";
    }

}
