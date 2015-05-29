package session4.hw1;

/**
 * Created by oleg on 27.05.15.
 */
public class User {
    private String login;
    private String password;
    private String dateOfRegistration;
    private int rating;
    private int sex;

    public User(String login, String password, String dateOfRegistration, int rating, int sex) {
        this.login = login;
        this.password = password;
        this.dateOfRegistration = dateOfRegistration;
        this.rating = rating;
        this.sex = sex;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o){
        return (login.equals(((User) o).login) && password.equals(((User) o).password) && dateOfRegistration.equals(((User)o).dateOfRegistration) && rating == ((User)o).rating && sex == ((User)o).sex);
    }

    @Override
    public int hashCode(){
        return login.hashCode() + password.hashCode() + dateOfRegistration.hashCode() + rating + sex;
    }
}


class UserTest{
}
