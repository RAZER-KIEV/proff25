package session7;

import sun.util.resources.cldr.guz.LocaleNames_guz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by jax on 09.06.15.
 */
public class TestJdbc {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
