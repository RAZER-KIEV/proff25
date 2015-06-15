package session8;

import java.sql.*;

/**
 * Created by bosyi on 15.06.15.
 */
public class TestingSQL {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TABLE1");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("LOGIN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
