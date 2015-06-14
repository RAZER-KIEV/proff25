package hw5.auth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by rrudych on 12.06.15.
 */
public class UserJDBCManager{

    Connection connect;
    Statement stmt;

    public int create(User user) {
        Locale.setDefault(Locale.ENGLISH);
        int result;
        try {
            connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            stmt = connect.createStatement();
            ResultSet res = stmt.executeQuery("SELECT user_name, user_id FROM users");

            int lastId = 0;
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

    public List<User> findAll(){
        Locale.setDefault(Locale.ENGLISH);
        List<User> list = new ArrayList<>();
        try{
            connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            stmt = connect.createStatement();
            ResultSet res = stmt.executeQuery("SELECT user_name, user_password, user_date FROM users");
            while(res.next()) {
                list.add(new User(res.getString("user_name"), res.getString("user_password"), res.getString("user_date")));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return list;
    }

    public User readByNamePass(String login, String pass) {
        Locale.setDefault(Locale.ENGLISH);
        User user = null;
        try {
            connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            stmt = connect.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM users");
            while(res.next()) {
                String currentName = res.getString("user_name");
                String currentPass = res.getString("user_password");
                if(currentName.equalsIgnoreCase(login) && currentPass.equals(pass)) {
                   user = new User(currentName, currentPass, res.getString("user_date"));
                   return user;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
}
