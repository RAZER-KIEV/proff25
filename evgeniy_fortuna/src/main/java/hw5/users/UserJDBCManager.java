package hw5.users;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class UserJDBCManager {

    private Connection db = null;

    public UserJDBCManager() {
        connectBase();
    }
    private void connectBase()  {
        Locale.setDefault(Locale.ENGLISH);
        Connection conectBase = null;
        try {
            conectBase = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            if(conectBase != null) {
                db = conectBase;
                System.out.println("Соедениение с БД установлено");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Connection getDb() {
        return db;
    }
    public boolean isDb() {return db != null ? true : false; }

    public List<User> findAll() {
        List<User> lists = new ArrayList<>();
        if(isDb()) {
            Statement statement = null;
            String selectAllUser = "select * from USERS";
            try {
                statement = this.getDb().createStatement();
                ResultSet resultSet = statement.executeQuery(selectAllUser);
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getString("id"));
                    user.setName(resultSet.getString("name"));
                    user.setPass(resultSet.getString("password"));
                    Date date = resultSet.getDate("dattime");
                    String dateFormatted = new SimpleDateFormat("dd.MM.yyyy").format(date).toString();
                    user.setDate(dateFormatted);
                    lists.add(user);
                }
                System.out.println("Test");
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(lists.size());
        return lists;
    }

    public int create(User tt) {
        return 0;
    }
}

