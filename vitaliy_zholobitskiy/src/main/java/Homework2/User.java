package Homework2;

/**
 * Created by just1ce on 19.05.2015.
 */
public class User implements Comparable<User> {
    public String login;
    public String password;
    public String regdate;
    double rate;
    int gender;
    public User(){

    }
    public User(String log, String pass, String date,double rate,int gender)
    {
        this.login=log;
        this.password=pass;
        this.regdate=date;
        this.rate=rate;
        this.gender=gender;
    }

    @Override
    public int hashCode()
    {
        return this.login.hashCode()+this.password.hashCode()+Double.hashCode(this.rate)+gender;
    }
    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        if (obj==null){
            return false;
        }
        if (!(obj.getClass()==getClass()))
            return false;
        User val=(User)obj;
        if ( login!=null &&
                login.equals(val.login)&&
                regdate.equals(val.regdate)&&
                password!=null &&
                password.equals(val.password)&&
                rate==val.rate&&
                gender==val.gender
                )
            return true;
        return false;
    }

    @Override
    public int compareTo(User o) {

        if (rate>o.rate)
            return 1;
        else if (rate==o.rate)
            return 0;
        else
            return -1;
    }
    @Override
    public String toString() {

        return "Login = " + login + " Pass = " + password+ " Registration = " + regdate+" Gender = "+gender+" Rate = "+rate+"\r\n";
    }
}
/*class UserTest{
    void test(){
        User user1= new User("qwerty","132","21.06.98",57.5,1);
        User user2= new User("qwerty1","1323","21.05.98",28.5,1);
        User user3= new User("qwerty","132","21.06.98",57.5,1);
        User user4= new User("qwerty","132","20.06.98",57.5,2);
        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(user3));
        System.out.println(user1.equals(user4));
        System.out.println(user2.equals(user3));
        System.out.println(user2.equals(user4));
        System.out.println(user3.equals(user4));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
        System.out.println(user4.hashCode());
    }
}*/
