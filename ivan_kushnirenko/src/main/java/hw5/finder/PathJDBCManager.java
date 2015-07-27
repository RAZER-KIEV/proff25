package hw5.finder;


import hw5.auth.User;

import java.sql.*;
import java.util.*;

/**
 * Created by ivan on 26.07.15.
 */
public class PathJDBCManager {

    private Connection connection;
    private Statement statement;

    public PathJDBCManager() {
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

    public int create(Path path) {
        String query = "INSERT INTO FILES (ID,PATH,CR_DATE) VALUES ('" + path.getId() + "', " +
                "'" + path.getPath() + "', '" + path.getDate() + "')";
        try {
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException exp){
            System.out.println("ERROR: Cannot insert file: "+path);
            exp.printStackTrace();
            return 0;
        }
        return 1;
    }

    public List findAll() {
        String query = "SELECT * FROM FILES";
        List<Path> files = new ArrayList<Path>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String filePath = resultSet.getString("PATH");
                java.util.Date cr_date = resultSet.getDate("CR_DATE");
                Path path = new Path(filePath,cr_date);
                path.setId(Long.valueOf(id));
                files.add(path);
            }
        } catch (SQLException exp) {
            System.out.println("ERROR: Cannot get all users from db.");
            exp.printStackTrace();
        }
        return files;
    }

}
