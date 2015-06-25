package session8;

import sun.util.resources.cldr.guz.LocaleNames_guz;

import java.sql.*;
import java.util.Locale;

/**
 * Created by jax on 09.06.15.
 */
public class TestJdbc {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            System.out.println(conn);
            Statement stmt= conn.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT * FROM employees");

            while (rs.next()){
                System.out.println(rs.getString("FIRST_NAME")+" "+rs.getString("Last_name"));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
