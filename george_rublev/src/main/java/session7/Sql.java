package session7;

//import java.sql.Connection;

import java.sql.*;
import java.util.Locale;

/**
 * Created by george on 08.06.15.
 */
public class Sql {
    public static void main(String[] args) {


        try {
            Locale.setDefault(Locale.ENGLISH);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
            System.out.println(connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM HR.EMPLOYEES");


            while(resultSet.next()){
            long id = resultSet.getLong(1);

            System.out.println(id);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
