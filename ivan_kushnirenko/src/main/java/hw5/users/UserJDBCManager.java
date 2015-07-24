package hw5.users;

import java.sql.*;
import java.util.List;
import java.util.Locale;

/**
 * Created by ivan on 24.07.15.
 */

/*
Написать приложение, позволяющее добавлять нового пользователя и просматривать
список существующих пользователей. Структура таблицы (id, имя, пароль, дата).

В класс UserJDBCManager поместите все операции с базой данных. Желательно в
методы этого класс передовать и возвращать объекты класса User

public int create(User user)
public List findAll()

База данных:
 Login: User
 Password: User
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
        List<User> users = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME_USER");
                String password = resultSet.getString("PASSWORD");
                Date reg_date = resultSet.getDate("REG_DATE");
                users.add(new User(id, name, password, reg_date));
            }
        } catch (SQLException exp) {
            System.out.println("ERROR: Cannot get all users from db.");
            exp.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args) {
        UserJDBCManager userJDBCManager = new UserJDBCManager();
        User user = new User(1, "John", "desperado77", new Date(System.currentTimeMillis()));
        userJDBCManager.create(user);

    }

}
