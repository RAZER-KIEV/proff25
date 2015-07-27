package session2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by viktoria on 19.05.15.
 */
class User implements Comparable<User>{

    private String login;
    private String password;
    private Integer expDay;


    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setExpDay(int expDay) {
        this.expDay = expDay;
    }

    public Integer getExpDay() {
           return expDay;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public User(String login,String password){
        this.login = login;
        this.password = password;
    }


    public User(String login,String password, Integer expDay ){
        this.login = login;
        this.password = password;
        this.expDay= expDay;

    }

     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass()  != obj.getClass()) return false;

        User user = (User) obj;

        if (expDay != user.expDay) return false;
         if(!login.equals(user.login)) return false;
         return password.equals(user.password);

    }

     @Override
    public int  hashCode(){
        return login.hashCode() + password.hashCode();
    }


    @Override
    public int compareTo(User user) {
        if (expDay.compareTo(user.getExpDay())>0){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString(){
        return "User " + " " + login + " password: " + password + " ExpDate: "+expDay;
    }
}

class Auth{

    public static void main(String[] args) {
        Auth auth = new Auth();
//        System.out.println(auth.authenticate("123","ddd"));
//        System.out.println(auth.authenticate("iuad","test"));
//        System.out.println(auth.authenticate("asderf", "12345"));

        Comparator <User> compPass = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                    return o1.getPassword().compareTo(o2.getPassword());
            }
        };
    }

    private Set <User> users = new TreeSet<>();

    public Auth () {

        users.add(new User("iuad", "test", 12) );
        users.add(new User ("asderf", "12345", 33));
        users.add(new User ("qwer", "eee", 1156));
        users.add(new User ("Ivan", "VVV", 44));
        users.add(new User ("Test5", "555",0));

        System.out.println(users);
        System.out.println();
    }

    public boolean authenticate(String login, String password){
        return users.contains(new User (login,password));
        }


    }

