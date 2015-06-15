package hw5.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Роман on 11.06.2015.
 */
public class UserJDBCManager {
    private Connection connect;
    private Statement stmt;
    private ResultSet resultSet;


    public int create(User user) {
        Locale.setDefault(Locale.ENGLISH);
        int result;
        try {
            connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            stmt = connect.createStatement();
            ResultSet res = stmt.executeQuery("SELECT user_name, user_id FROM users");

            int lastId=0;
            int currentId;
            while(res.next()) {
                if(res.getString(1).equalsIgnoreCase(user.getName())) {
                    return -1;
                }
                currentId = res.getInt(2);
                if (currentId>lastId){
                    lastId = currentId;
                }
            }
            result = stmt.executeUpdate("INSERT INTO users VALUES ('"+(lastId+1)+"', '"+user.getName()+"', '"+user.getPassword()+"', '"+user.getDate()+"')");
        } catch(SQLException ex) {
            System.out.println("DB connection problem");
            ex.printStackTrace();
            return -1;
        }
        return result;
    }

    public List<User> findAll() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        List<User> list = new ArrayList<>();
        Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement stmt = connect.createStatement();
        resultSet = stmt.executeQuery("SELECT * FROM users");
        while(resultSet.next()) {
            list.add(new User(resultSet.getString("user_name"), resultSet.getString("user_password"), resultSet.getString("user_date")));
        }
        return list;
    }
}
