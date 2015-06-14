package hw5.users;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Jeckgehor on 14.06.2015.
 */
public class MainWindow {

    public  static void main (String[] args) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        User user1 = new User("Jeck", "1230po");
        User user2 = new User("Rock", "4145jgj");
        User user3 = new User("Ben", "hgjh4871");
        User user4 = new User("Olaf", "ug555");
        User user5 = new User("Inga", "02125vnfj");
        UserJDBCManager.create(user1);
        UserJDBCManager.create(user2);
        UserJDBCManager.create(user3);
        UserJDBCManager.create(user4);
        UserJDBCManager.create(user5);
        System.out.println(UserJDBCManager.findAll());
    }
}

class  UserJDBCManager {

    public static int create(User user) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement stmt = conn.createStatement();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = Calendar.getInstance().getTime();
        String str = "INSERT INTO users_base (id, name, password, date_insert) VALUES (USER_BASE_SEQ.nextVal,'"
                + user.name + "', '" + user.password + "', '" + sdf.format(date) + "')";
        System.out.println(str);
        int rs = stmt.executeUpdate (str);
        return rs;
    }

    public static List findAll() throws SQLException {
        List list = new ArrayList<>();
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users_base");
        while (rs.next()) {
            list.add(new User(rs.getString(2),rs.getString(3)));
        }
        return list;
    }
}

class User {
    String name;
    String password;

    User (String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        String str = "Name: " + this.name + "; password: " + this.password;
        return  str;
    }
}
