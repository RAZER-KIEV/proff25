package hw5.auth;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Well on 14.06.2015.
 */
public class UserJDBCManager {
    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String LOGIN = "hr";
    private final String PASSWORD = "hr";
    private Connection conn;

    {
        Locale.setDefault(Locale.ENGLISH);
    }

    private void connect() {
        try {
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    private void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<User> findAll() {
        connect();
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                User user = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("password"),
                        rs.getString("date_reg"));
                userList.add(user);
            }

        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            close();
        }
        return userList;
    }


    public int create(User user) {
        connect();
        int res = 0;
        try {
            Statement stmt = conn.createStatement();

            res = stmt.executeUpdate("INSERT INTO users (USER_ID, USER_NAME, PASSWORD, DATE_REG) VALUES (USERS_SEQ.NEXTVAL, '" +
                    user.getName() + "', '" + user.getPass() + "', '" + user.getRegDate() + "'  )");

        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            close();
        }

        return res;
    }

    public User readByNamePass(String login, String pass) {
        connect();
        User resUser = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                if (login.equalsIgnoreCase(rs.getString("user_name")) && pass.equals(rs.getString("password"))) {
                    resUser = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("password"), rs.getString("date_reg"));
                    return resUser;
                }
            }
        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            close();
        }
        return resUser;
    }
}