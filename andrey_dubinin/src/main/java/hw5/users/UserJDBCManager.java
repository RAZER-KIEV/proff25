package hw5.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jax on 13.06.15.
 */
public class UserJDBCManager {
    Connection conn;
    Statement stmt;
    public UserJDBCManager() {
        try {
            this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            this.stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int create(User user){
        try {
            PreparedStatement stat = conn.prepareStatement("INSERT INTO Users VALUES(?,?,?,?)");
            int id =user.getId();
            String name =user.getName();
            int pass= user.getPassword();
            String date = user.getDate();
            stat.setInt(1,id);
            stat.setString(2, name);
            stat.setInt(3, pass);
            stat.setString(4, date);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public List<User> findAll(){
        List<User> list = new ArrayList<>();
        try {
            ResultSet rs =stmt.executeQuery("SELECT * FROM users");
            while(rs.next()){
               int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int pass = rs.getInt("PASSWORD");
                String date = rs.getString("DATE_CREATE");
                list.add(new User(name,id,pass,date));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
