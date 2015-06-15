package session8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Inna on 09.06.2015.
 */
public class ConnectEx {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started..");

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
