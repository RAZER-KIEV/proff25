package session8;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by bosyi on 09.06.15.
 */
public class TestJDBCDriver {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try(Connection connection =
                    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr"))
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT FIRST_NAME, LAST_NAME, DEPARTMENT_ID, HIRE_DATE FROM EMPLOYEES");
            System.out.printf("%15s%15s%7s%15s\n", "FIRST_NAME", "LAST_NAME", "DEP_ID", "HIRE_DATE");
            while (resultSet.next()) {
                String date = new SimpleDateFormat("YYYY.mm.dd").format(resultSet.getDate("HIRE_DATE"));
                System.out.printf("%15s%15s%7d%15s\n", resultSet.getString("FIRST_NAME"), resultSet.getString("LAST_NAME"), resultSet.getLong("DEPARTMENT_ID"), date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
