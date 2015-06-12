package hw5.users;

import java.sql.SQLException;

/**
 * Created by oleg on 10.06.15.
 */
public class MainWindow {
    public static void main(String[] args) throws SQLException {
        UserJDBCManager man = new UserJDBCManager();
        man.printUsers();
//        man.create(User.addUser());
//        man.printUsers();
    }
}
