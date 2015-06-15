package session8;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by bosyi on 09.06.15.
 */
public class AddCountryToTable {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try(Connection connection =
                    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr"))
        {
            Statement statement = connection.createStatement();
//            statement.executeQuery("INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME, REGION_ID) VALUES ('UA', 'UKRAINE', 1)");
            statement.executeUpdate("UPDATE COUNTRIES SET COUNTRY_NAME = 'GREAT UKRAINE' WHERE COUNTRY_ID = 'UA'");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
