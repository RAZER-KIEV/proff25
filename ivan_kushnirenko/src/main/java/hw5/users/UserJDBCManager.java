package hw5.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by ivan on 24.07.15.
 */

public class UserJDBCManager {

    private Connection connection;
    private Statement statement;

    public UserJDBCManager() {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "User", "User");
            System.out.println("DB manager was created.");
        } catch (ClassNotFoundException exp) {
            System.out.println("ERROR: Cannot create driver.");
            exp.printStackTrace();
        } catch (SQLException exp) {
            System.out.println("ERROR: Cannot connect to db.");
            exp.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int create(User user) {
        String createUserQuery = "INSERT INTO USERS(ID, USER_NAME, PASSWORD, REGIST_DATE) VALUES ('" +
                user.getId() + "','" +
                user.getName() + "','" +
                user.getPassword() + "','" +
                user.getDate() + "')";
        try {
            statement = connection.createStatement();
            statement.execute(createUserQuery);
        } catch (SQLException exp) {
            System.out.println("ERROR: Cannot create new user: " + user);
            exp.printStackTrace();
            return 0;
        }
        return 1;
    }

    public List<User> findAll() {
        String query = "SELECT * FROM USERS";
        List<User> users = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("USER_NAME");
                String password = resultSet.getString("PASSWORD");
                Date reg_date = resultSet.getDate("REGIST_DATE");
                users.add(new User(id, name, password, reg_date));
            }
        } catch (SQLException exp) {
            System.out.println("ERROR: Cannot get all users from db.");
            exp.printStackTrace();
        }
        return users;
    }

    private void closeConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException exp) {
            System.out.println("ERROR: Cannot close connection.");
            exp.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserJDBCManager userJDBCManager = new UserJDBCManager();
        //User user = new User(1, "John", "desperado77", new Date(System.currentTimeMillis()));
        System.out.println(userJDBCManager.findAll());
        userJDBCManager.closeConnection();
    }

}
