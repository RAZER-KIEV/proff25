package hw5.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by viktoria
 * Project:.hw5.users
 */
public class UserJDBCManager {
    User user;
    List<User> users;


    public UserJDBCManager() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement stat = conn.createStatement();

        int table = stat.executeUpdate("CREATE TABLE USERS (ID  INT NOT NULL" +
                "                                         , USERNAME VARCHAR (25) NOT MULL" +
                "                                         , PASSWORD VARCHAR (25) NOT NULL" +
                "                                         , CURDATE CURRENT_DATE NOT NULL )" );
        conn.close();
        stat.close();

    }

    public int create(User user) throws SQLException {
        this.user = user;
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement stat = conn.createStatement();

//        ResultSet add = stat.executeUpdate("INSERT  INTO USERS (USERNAME, PASSWORD) " +
//                " VALUES (" "\"+user.getName()+\"" ", "'"+user+"'");

        return 1;
    }

    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement stat2 = conn.createStatement();
        ResultSet query = stat2.executeQuery("SELECT  * FROM USERS ");
        while(query.next()){
            users.add(new User(query.getInt("ID"), query.getString(2), query.getString(3), query.getDate(4)));
            System.out.println(query.getInt("ID")+"  "+ query.getString(2) +"  " +
                    query.getString(3) +"   " + query.getDate(4));

        }
        conn.close();
        stat2.close();
        return users;

    }


}
