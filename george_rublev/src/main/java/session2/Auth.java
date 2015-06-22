package session2;//package session2;
//
//import java.hw6.notes.util.*;
//
//
///**
// * Created by george on 19.05.15.
// */
//
//public class Auth {
//    public static void main(String[] args) {
//        Auth auth = new Auth();
////        System.out.println(auth.checkUser("Us","ww"));
////        System.out.println(auth.checkUser("www","sss"));
////        TreeSet<User> hw5 = new TreeSet<>();
////        hw5.add(new User())
//        System.out.println();
//    }
////        private Set<User> hw5 = new HashSet<>();
//TreeSet<User> hw5 = new TreeSet<>();
//    public Auth(){
//        hw5.add(new User("Us","ww"));
//        hw5.add(new User("Us1","ww2"));
//    }
//
//        public boolean checkUser(String login, String passwrd) {
////            if(hw5.contains(login) && hw5.contains(passwrd)) {
////                return true;
////            }
//            for(User user : hw5){
////                if(user.getPas().equals(login) && user.getPas().equals(passwrd)){
////                    return true;
////                }
//            }
//            return false;
//        }
//
//    }
//
//class User implements Comparable<User>{
//    private String login = null;
//    private String passwd = null;
//    private int expireDaysCount;
//    User(String login, String passwd){
//        this.login=login;
//        this.passwd=passwd;
//        expireDaysCount = 10;
//    }
//
//    @Override
//    public int compareTo(User o) {
//        return o.getLogin().compareTo(getPas());
//    }
//    @Override
//    public int hashCode(){
//        return login.hashCode()+passwd.hashCode();
//    }
//    public String getLogin(){
//        return login;
//    }
//    public String getPas(){
//        return passwd;
//    }
////    @Override
////    private String toString(User user){
////        return "Login: " + user.getLogin() + " Password :" + user.getPas();
////    }
//
//}