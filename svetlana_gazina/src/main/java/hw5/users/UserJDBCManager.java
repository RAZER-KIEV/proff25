package hw5.users;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


/**
 * Created by Sveta on 6/12/2015.
 *
 * Написать приложение, позволяющее добавлять нового пользователя и просматривать список существующих пользователей. Структура таблицы (id, имя, пароль, дата).

 Классы задания:
 hw5.users.MainWindow
 hw5.users.UserJDBCManager
 hw5.users.User

 В класс UserJDBCManager поместите все операции с базой данных. Желательно в методы этого классa передавать и возвращать объекты класса User

 public int create(User user)
 public List<User> findAll()
 */
public class UserJDBCManager {
    int id = 0;
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);

        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement statement = conn.createStatement();
        String sql = "CREATE TABLE USERS("
                + "USER_ID NUMBER(5) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "PASSWORD VARCHAR(20) NOT NULL, "
                + "REGISTRATION_DATE DATE NOT NULL, "
                + "PRIMARY KEY (USER_ID)"
                + ")";
        System.out.println(sql);
        int i = statement.executeUpdate(sql);
        System.out.println(i);
    }

    public int create(User user) throws SQLException {

        if(checked(user)){
            id++;
            Locale.setDefault(Locale.ENGLISH);
            java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());

            String sql = "INSERT INTO users(user_id, username, password, registration_date) VALUES(?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setDate(4, currentDate);
            return 1;
        }

        return -1;
    }

    public List<String> findAll() throws SQLException {
        List<String> users = new LinkedList<>();
        Locale.setDefault(Locale.ENGLISH);

        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT username FROM users");

        while(resultSet.next()) {
            users.add(resultSet.getString(1));
        }

        conn.close();
        return users;
    }

    private boolean checked(User user) throws SQLException {
        String pass = user.getPassword();
        Locale.setDefault(Locale.ENGLISH);

        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery( "SELECT password FROM users");
        while(resultSet.next()){
            if(resultSet.getString(1) == pass){
                return false;
            }
        }
        return true;
    }

}
