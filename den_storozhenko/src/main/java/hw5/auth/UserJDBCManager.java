package hw5.auth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class UserJDBCManager {
    Statement statement;

    public UserJDBCManager() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        statement = connection.createStatement();
    }

    public int create(User user) throws SQLException {
        if (!statement.executeQuery("SELECT NAME FROM USERS WHERE NAME='" + user.getName() + "'").next()){
            statement.executeUpdate("INSERT INTO USERS(USER_ID, NAME, PASSW, DATA) VALUES (USER_SEQ.NEXTVAL,'"+user.getName()+"','"+
                    user.getPassword()+"',TO_DATE('"+user.getDate()+"','YYYY-MM-DD'))");

            ResultSet resultSet = statement.executeQuery("SELECT USER_ID FROM USERS WHERE NAME='"+user.getName()+ "'");
            resultSet.next();
            return resultSet.getInt(1);
        }
        return -1;
    }

    public void delete(String name) throws SQLException {
        statement.executeUpdate("DELETE FROM USERS WHERE NAME='"+name+"'");
    }

    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
        while (resultSet.next()){
            users.add(new User(resultSet.getString("NAME"), resultSet.getString("PASSW"), resultSet.getDate("DATA")));
        }

        return users;
    }

    public User readByNamePass(String login, String pass) throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS WHERE (NAME='"+login+"' AND PASSW='"+pass+"')");
        if (resultSet.next()){
            return new User(resultSet.getString("NAME"),resultSet.getString("PASSW"),resultSet.getDate("DATA"));
        }
        return null;
    }
}
