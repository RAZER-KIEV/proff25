package hw5.auth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public List<User> findAll() throws SQLException {
        List<User> list = new ArrayList<>();
        ResultSet res = stmnt.executeQuery("SELECT * FROM USERS");
        while (res.next()) {
            int id = res.getInt("ID");
            String name = res.getString("NAME");
            String password = res.getString("PASSWORD");
            java.util.Date registration_date = res.getDate("REGISTRATION_DATE");
            list.add(new User(id, name, password, registration_date));
        }
        return list;
    }

    public int create(User user){
        try {
            PreparedStatement pstmnt = conn.prepareStatement("INSERT INTO USERS(ID, NAME, PASSWORD, REGISTRATION_DATE) VALUES (?, ?, ?, ?)");
            pstmnt.setInt(1, user.getId());
            pstmnt.setString(2, user.getName());
            pstmnt.setString(3, user.getPassword());
            pstmnt.setDate(4, Date.valueOf("2015-7-10"));
            pstmnt.executeUpdate();
        } catch (SQLException sqlEx){
            return 0;
        }
        return  1;
    }

    public User readByNamePass(String login, String pass) throws SQLException {
        ResultSet res = stmnt.executeQuery("SELECT * FROM USERS");
        while (res.next()) {
            if(res.getString("NAME").equals(login)){
                if (res.getString("PASSWORD").equals(pass)){
                    return  new User(res.getInt("ID"), login, pass, res.getDate("REGISTRATION_DATE"));
                }
            }
        }
        return null;
    }
}
