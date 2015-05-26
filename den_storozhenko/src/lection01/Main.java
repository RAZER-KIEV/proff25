package lection01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by storo_000 on 19.05.2015.
 */
public class Main{
    public static void main(String[] args) {
        Auth auth = new Auth();
        auth.getSet().add(new User("Log1", "pssw1", 12));
        auth.getSet().add(new User("Log2", "pssw1", 12));
        auth.getSet().add(new User("Log3", "pssw3", 14));
        System.out.println(auth.isAuthorizated("Log1", "pssw1"));
        System.out.println(auth.isAuthorizated("Log2", "pssw2"));
        System.out.println(auth.isAuthorizated("Log3", "pssw3"));


       /* Comparator<User> userComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                *//*if (o1.getTime()>o2.getTime()) return 1;
                if (o1.getTime()<o2.getTime()) return -1;
                return 0;*//*
                return (o1.getPassword().compareTo(o2.getPassword()));
            }
        };
        TreeSet<User> treeSet = new TreeSet<User>(userComparator);*/

        TreeSet<User> treeSet = new TreeSet<User>();

        treeSet.add(new User("Log1", "pssw1", 12));
        treeSet.add(new User("Log2", "pssw1", 16));
        treeSet.add(new User("Log3", "pssw3", 14));
        treeSet.add(new User("Log4", "pssw4", 122));
        treeSet.add(new User("Log5", "pssw5", 1));
        System.out.println(treeSet.toString());
    }
}

class Auth{
    private HashSet<User> set = new HashSet<User>();

    public HashSet<User> getSet(){
        return set;
    }

    public boolean isAuthorizated(String log, String passw){
        return (set.contains(new User(log,passw)));
    }
}

class User implements Comparable<User>{
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

    User(String log, String passw, int t){
        login=log;
        password=passw;
        time=t;
    }

    User(String log, String passw){
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
        User u=(User)object;
        if (    login!=null &&
                password!=null &&
                u.login.equals(login) &&
                u.password.equals(password) //&&
            //u.time == time
                )
            return true;
        return false;
    }

    @Override
    public int hashCode(){
        return login.hashCode()+password.hashCode();//+time;
    }

    @Override
    public int compareTo(User user) {
        if (time>user.time) return 1;
        if (time<user.time) return -1;
        return 0;
    }

    @Override
    public String toString(){
        return "User "+login + ", password "+password+", time "+time+"\n";
    }
}

//—оздать класс пользователь с пол€ми логин, пароль, врем€ истечени€ действи€ парол€
//–еализовать метод, которому передаетс€ логин и пароль пользовател€. ћетод определ€ет, авторизирован пользователь или нет
//(есть ли в списке пользователей). —вер€ет по хешкоду и equals.

//—оздать 5 пользователей, упор€дочить их по возрастанию кол-ва дней до истечени€ строка действи€ паролей


/*
* ArrayList
*
*
* —равнить ArrayList и LinkedList.
*
* —равнить производительность:
*   - добавление в начало
*   - добавление в конец
*   - добавление в середину
*   - получение элемента по индексу
*   - удаление элемента из начала
*   - поиск элемента по значению(indexOf)
*
*
*
*
*
*
* */