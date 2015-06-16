package session7_8;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;


/**
 * Created by Sveta on 6/9/2015.
 */
public class Jdbc {
    public static void main(String[] args) throws SQLException {

        Locale.getDefault();
        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr", "hr");
        System.out.println(conn);
        conn.close();
    }
}
