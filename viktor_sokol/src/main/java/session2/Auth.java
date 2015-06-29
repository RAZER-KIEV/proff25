package session2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Віктор on 5/19/2015.
 */
public class Auth {
    private Set<User> users = new HashSet<User>();

    public boolean authenticate(String login, String parole) {
        return false;
    }

    class User {
        private String login;
        private String parole;
        private int actionTime;

        public User(String login, String parole) {
            this.login = login;
            this.parole = parole;
        }

        @Override
        public int hashCode() {
            return login.hashCode() + parole.hashCode();
        }
//        @Override
//        public boolean equals (Object obj){
//            if (obj = null){
//                return false;
//            }
//            if (obj)
//        }
    }
}
