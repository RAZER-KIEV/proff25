package session2;

import java.util.Collections;

/**
 * Created by Sveta on 5/19/2015.
 */
public class User implements Comparable<User>{
    private String name;
    private String password;
    private int days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {

        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }



   public User(String name, String password){
       this.name = name;
       this.password = password;
   }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override

    public int hashCode(){
        return name.hashCode() + password.hashCode();
    }

    @Override
    public int compareTo(User user) {
        if(this.days > days){
        return 1;}
        if(this.days == days){
            return 0;}

            return -1;
    }

}
