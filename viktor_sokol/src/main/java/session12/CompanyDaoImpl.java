package session12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Віктор on 6/23/2015.
 */
public class CompanyDaoImpl implements CompanyDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    public CompanyDaoImpl() {
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Password1@");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
