package homework2;

/**
 * Created by bosyi on 01.06.15.
 */
public class User {

    private String login;
    private String password;
    private int day;
    private int month;
    private int year;
    private int rating;
    private int sex; // 0 - male, 1 - female

    public User() {

    }

    public User(String login, String password, int day, int month,
                int year, int rating, int sex) {
        this.login = login;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.rating = rating;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (day != user.day) return false;
        if (month != user.month) return false;
        if (year != user.year) return false;
        if (rating != user.rating) return false;
        if (sex != user.sex) return false;
        if (!login.equals(user.login)) return false;
        return password.equals(user.password);

    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + day;
        result = 31 * result + month;
        result = 31 * result + year;
        result = 31 * result + rating;
        result = 31 * result + sex;
        return result;
    }
}
