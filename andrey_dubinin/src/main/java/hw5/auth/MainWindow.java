package hw5.auth;

import java.util.Locale;

/**
 * Created by jax on 13.06.15.
 */
public class MainWindow {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        UserJDBCManager accounts = new UserJDBCManager();
       // User user = new User("Pepsi",3,8765,"13.06.2015");

        accounts.readByNamePass("Pepsi",8765);
    }
}
