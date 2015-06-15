package session7_8;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;



/**
 * Created by Sveta on 6/9/2015.
 */
public class Employees {
    public static void main(String[] args) throws SQLException {
        List<String> users = new LinkedList<>();
        Locale.setDefault(Locale.ENGLISH);

        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT username FROM users");

        while(resultSet.next()) {
            users.add(resultSet.getString(1));
        }

        conn.close();
        System.out.println(users);

    }


}
