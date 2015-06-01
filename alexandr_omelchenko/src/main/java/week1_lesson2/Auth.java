package week1_lesson2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Oleksandr on 21.05.2015.
 */
public class Auth {
    public static void main(String[] args) {
        Auth auth = new Auth();
        Auth.User u1=new Auth().new User("men1", "k1");
        Auth.User u2=new Auth().new User("men2", "k2");
        Auth.User u3=new Auth().new User("men3", "k3");
        Auth.User u4=new Auth().new User("men4", "k4");
        Auth.User u5=new Auth().new User("men5", "k5");
        auth.users.add(u1);
        auth.users.add(u2);
        auth.users.add(u3);
        auth.users.add(u4);
        auth.users.add(u5);

       Iterator iter =auth.users.iterator();
        while (iter.hasNext()){
           System.out.println(iter.next().toString()) ;
        }
      System.out.println(auth.authorization("men1", "k1"));
    }
//Êîíåö ÌÅÉÍÀ

  public Set<User> users = new TreeSet<>(compPass);
  //public Set<User> users = new HashSet<>();

    public static Comparator<User> compPass = new Comparator<User>() {
        public int compare(User o1, User o2) {
           int t1= o1.getLogin().compareTo(o2.getLogin());
            if(t1!=0) return  t1;
            else return o1.getKey().compareTo(o2.getKey());
        }
    };
    public boolean authorization(String l, String k){
        User us = new User(l, k);
        return users.contains(us);
    }
    //ÍÀ×ÀËÎ Şçåğà
    class User implements Comparable<User> {
        private String login;
        private String key;
        private int days = 30;

        public User(String l, String k) {
            login = l;
            key = k;                    }

        public String getLogin() {
            return login;        }
        public void setLogin(String login) {
            this.login = login;            }

        public String getKey() {
            return key;       }
        public void setKey(String key) {
            this.key = key;            }

        public int getDays() {
            return days;     }
        public void setDays(int days) {
            this.days = days;         }

        @Override
        public boolean equals(Object obj) {
            if(obj==null){return false;}
            if(obj==this){return true;}
            if(obj.getClass()!=getClass()){return false;}
            User us = (User) obj;
            if(this.login.equals(us.login)&&
                    this.key.equals(us.key)&&
                    this.days==us.days)
                return true;
            else return false;
        }
        @Override
        public int hashCode() {
            return login.hashCode()+key.hashCode()+days;
        }
        @Override
        public String toString(){
            return "User{"+getLogin()+" "+getKey()+"}";
        }
        @Override
        public int compareTo(User user) {
            return this.login.compareTo(user.login);
        }
    }
//Êîíåö User
}