package session2.Session2_tes.test1.test2;

/**
 * Created by oleg on 20.05.15.
 */
public class User implements  Comparable{
    private String login;

    public String getPassword() {
        return password;
    }

    private String password;
    private int timeOfAvailability;


    public User(String login, String password, int timeOfAvailability) {
        this.login = login;
        this.password = password;
        this.timeOfAvailability = timeOfAvailability;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public int hashCode(){
        return login.hashCode() + password.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null | this == null | obj.getClass() != this.getClass()){
            return false;
        }
        User tmp = (User) obj;
        return ( tmp.login.equals(this.login) && tmp.password.equals(this.password) );
    }

    @Override
    public int compareTo(Object o) {
        User tmp = (User) o;
        return this.login.compareTo(tmp.login);
    }
    @Override
    public String toString(){
        return login+ " " +password;
    }
}
