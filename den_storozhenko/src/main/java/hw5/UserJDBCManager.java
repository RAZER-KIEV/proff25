package hw5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class UserJDBCManager {
    private Statement statement;

    public UserJDBCManager(){
        Locale.setDefault(Locale.ENGLISH);
    }

    public int create(User user) throws SQLException {
        Connection connection = createStatement();

        if (!statement.executeQuery("SELECT NAME FROM USERS WHERE NAME='" + user.getName() + "'").next()){
            statement.executeUpdate("INSERT INTO USERS(USER_ID, NAME, PASSW, DATA) VALUES (USER_SEQ.NEXTVAL,'"+user.getName()+"','"+
                    user.getPassword()+"',TO_DATE('"+user.getDate()+"','YYYY-MM-DD'))");

            ResultSet resultSet = statement.executeQuery("SELECT USER_ID FROM USERS WHERE NAME='"+user.getName()+ "'");
            resultSet.next();
            return resultSet.getInt(1);
        }

        closeConnection(connection);
        return -1;
    }

    public void delete(String name) throws SQLException {
        Connection connection = createStatement();

        statement.executeUpdate("DELETE FROM USERS WHERE NAME='"+name+"'");

        closeConnection(connection);
    }

    public List<User> findAll() throws SQLException {
        Connection connection = createStatement();
        List<User> users = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
        while (resultSet.next()){
            users.add(new User(resultSet.getString("NAME"), resultSet.getString("PASSW"), resultSet.getDate("DATA")));
        }

        closeConnection(connection);
        return users;
    }

    public Connection createStatement() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        statement = connection.createStatement();
        return connection;
    }

    public void closeConnection(Connection connection) throws SQLException {
        statement.close();
        connection.close();
    }
}
