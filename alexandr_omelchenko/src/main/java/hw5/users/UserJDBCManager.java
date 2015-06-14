package hw5.users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJDBCManager {
    Connection conn;
public UserJDBCManager(Connection connection){
    conn=connection;}

    public int create(User user) {
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("Select ID FROM USERS ");
           int i=user.getId();
            String n = user.getName();
            String pass = user.getPassword();
            Date d = user.getDate();
System.out.println("i= "+i);
            stat.execute("INSERT INTO USERS VALUES(" + i + ",'" + n + "', '" + pass + "', TO_DATE('" + d + "','YYYY-MM-DD'))");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Alarm in addUser");
        }
        return 1;
    }
    public List<User> findAll(){
        List<User> list = new ArrayList<>();

        Statement stat = null;
        try {
            stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("Select * FROM USERS ");
        while (rs.next()) {
            int a=rs.getInt(1);
            String b=rs.getString(2);
            String c=rs.getString(3);
            Date d=rs.getDate(4);
        User temp = new User(a, b, c, d);
            list.add(temp);
        }
        }
        catch (SQLException e) {
                e.printStackTrace();}
    return list;
    }
}