package hw5.users;

import java.sql.*;
import java.util.Locale;

/**
 * Created by oleg on 10.06.15.
 */
public class UserJDBCManager {
    private Statement stmnt;
    private Connection conn;
    public UserJDBCManager() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        stmnt = conn.createStatement();
    }

    public void printUsers() throws SQLException {
        ResultSet res = stmnt.executeQuery("SELECT * FROM USERS");

        System.out.printf("%15s%15s%15s%20s\n", "id", "name", "password", "registration_date");
        while (res.next()) {
            Long id = res.getLong("ID");
            String name = res.getString("NAME");
            String password = res.getString("PASSWORD");
            java.util.Date registration_date = res.getDate("REGISTRATION_DATE");
            System.out.printf("%15d%15s%15s%15s\n", id, name, password, registration_date.toString());
        }
    }

    public void addUserToSheme(User user) throws SQLException {
        PreparedStatement pstmnt = conn.prepareStatement("INSERT INTO USERS(ID, NAME, PASSWORD, REGISTRATION_DATE) VALUES (?, ?, ?, ?)");
        pstmnt.setInt(1, user.getId());
        pstmnt.setString(2, user.getName());
        pstmnt.setString(3, user.getPassword());
        pstmnt.setDate(4, Date.valueOf("2015-7-10"));
        pstmnt.executeUpdate();
    }
}
