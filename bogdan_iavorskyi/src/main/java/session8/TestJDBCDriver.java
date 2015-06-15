package session8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by bosyi on 09.06.15.
 */
public class TestJDBCDriver {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try(
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr")) {
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
