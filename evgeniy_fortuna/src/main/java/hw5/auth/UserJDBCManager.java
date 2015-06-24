package hw5.auth;

import hw5.users.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserJDBCManager {

    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String LOGIN = "hr";
    private final String PASSWORD = "hr";
    private Connection connection;

    UserJDBCManager() {
        Locale.setDefault(Locale.ENGLISH);
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    private void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int create(User user) {
        connect();
        int temp = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String dateFormat = sdf.format(user.getUserDate());
        try {
            Statement stmt = connection.createStatement();
            temp = stmt.executeUpdate("INSERT INTO USERS VALUES ((SELECT nvl(MAX(user_id),0)+1 FROM users), '"
                    + user.getUserName() + "', '" + user.getUserPassword() + "',TO_DATE('" + dateFormat + "', 'dd.MM.yyyy'))");

        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            close();
        }
        return temp;
    }

    public List<User> findAll() {
        connect();
        List<User> resList = new ArrayList<User>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM users");
            while (results.next()) {
                User user = new User(results.getInt("USER_ID"), results.getString("USER_NAME"),
                        results.getString("USER_PASSWORD"), results.getDate("USER_DATE"));
                resList.add(user);
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            close();
        }
        return resList;
    }

    public User readByNamePass(String login, String pass) {
        connect();
        User tempUser = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT USER_NAME, USER_PASSWORD FROM users");
            while (results.next()) {
                if (login.equals(results.getString("USER_NAME")) && pass.equals(results.getString("USER_PASSWORD"))) {
                    return new User(results.getString("USER_NAME"), results.getString("USER_PASSWORD"));
                }
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            close();
        }
        return tempUser;
    }
}

