package hw5.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class MainWindow {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521/xe", "HR", "HR");
            UserJDBCManager manager =new UserJDBCManager(conn);
            //методы
          /*  manager.create(new User(1, "Sashenko","a44n73"));
            manager.create(new User(2, "Vasylyk","a44n73"));
            manager.create(new User(3, "Donatello","a44n73"));
            manager.create(new User(4, "Ivanov","a44n73"));
            manager.create(new User(5, "Petrov","a44n73"));
            manager.create(new User(6, "Sidorov","a44n73"));
            manager.create(new User(7, "Chyrka","a44n73"));
            manager.create(new User(8, "Don","a44n73"));
            manager.create(new User(9, "Seb","a44n73"));
            manager.create(new User(10, "Vitallino","a44n73"));
            manager.create(new User(11, "Rafaello","a44n73"));
            manager.create(new User(12, "Mikelanjelo","a44n73"));
            manager.create(new User(13, "Leonardo","a44n73"));
            manager.create(new User(14, "Omelchenko","a44n73"));
            manager.create(new User(15, "Sokolov","a44n73"));*/
         //   List<User> listik =manager.findAll();
            User us=manager.readByNamePass("melchenko","a44n73");
            System.out.println(us.toString());
           // System.out.print(listik.toString());
            conn.close();}

        catch (SQLException e) {
            System.out.println("Alarm in main");
            e.printStackTrace();
        }
    }
}
