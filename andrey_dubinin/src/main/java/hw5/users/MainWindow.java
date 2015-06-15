package hw5.users;

import java.util.Locale;

/**
 * Created by jax on 13.06.15.
 */
public class MainWindow {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        UserJDBCManager accounts = new UserJDBCManager();
        User user = new User("Neo",2,12234,"13.06.2015");
        accounts.create(user);

    }
}
