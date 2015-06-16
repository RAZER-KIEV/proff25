package hw5.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
 * В класс UserJDBCManager поместите все операции с базой данных.
 * Желательно в методы этого класс передовать и возвращать объекты класса User.
 */
public class UserJDBCManager {

    static {
        Locale.setDefault(Locale.ENGLISH);
    }

    private Connection connection;

    public boolean openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean closeConnection() {
        if (connection == null)
            return false;
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public int create(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS (USER_ID, LOGIN, PASSHASH, REGDATE) VALUES (USERSS_SEQ.nextval, '"+user.getLogin()+"','"+user.getHash()+"',?)");
            preparedStatement.setDate(1,user.getCreationDate());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void printUsers() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery("SELECT * FROM USERS");
            while (resSet.next()) {
                System.out.println(resSet.getString("LOGIN") + "|||" + resSet.getDate("REGDATE").getTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean remove(String login) throws SQLException {
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate("DELETE FROM USERS WHERE LOGIN = '"+login+"'");
        if (result == 0) {
            return false;
        } else {
            return true;
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
            while (resultSet.next()) {
                users.add(User.returnUser(resultSet.getString("LOGIN"),resultSet.getString("PASSHASH"),resultSet.getDate("REGDATE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
