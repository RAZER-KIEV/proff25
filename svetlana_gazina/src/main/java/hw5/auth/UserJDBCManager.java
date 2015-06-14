package hw5.auth;

import hw5.users.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sveta on 6/13/2015.
 * * Написать приложение выполняющее аутентификацию пользователя на основе учётной записи созданнной в предыдущем задании.
 * Если пользователь зарегистрирован, то выводим список зарегистрированных пользователей, если нет, выводим "Неправильный логин или пароль"

 public int create(User user)
 public List<User> findAll()
 public User readByNamePass(String login, String pass)

 Классы задания:
 hw5.auth.MainWindow
 hw5.auth.UserJDBCManager
 hw5.auth.User
 */
public class UserJDBCManager {
    int id = 0;
    public int create(hw5.users.User user) throws SQLException {

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

    private boolean checked(hw5.users.User user) throws SQLException {
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

    public User readByNamePass(String login, String pass) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);

        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery( "SELECT username, password FROM users");
        while(resultSet.next()){
            if(resultSet.getString(1) == login && resultSet.getString(2) == pass){
                return new User(login, pass);
            }
        }
        System.out.println("Неправильный логин или пароль");
        return null;
    }
}
