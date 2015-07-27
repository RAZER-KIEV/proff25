package hw5.equation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by ivan on 27.07.15.
 */
public class SolutionJDBCManager {

    private Connection connection;
    private Statement statement;

    public SolutionJDBCManager() {
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

    public int create(Solution solution) {
        String query = "INSERT INTO SOLUTIONS (ID,A,B,C,SOL1,SOL2) VALUES ('" + solution.getId() + "', " +
                "'" + solution.getA() + "', '" + solution.getB() +
                "', '" + solution.getC() + "', '" + solution.getSol1() +
                "', '" + solution.getSol2() +
                "')";
        try {
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException exp) {
            System.out.println("ERROR: Cannot insert file: " + solution);
            exp.printStackTrace();
            return 0;
        }
        return 1;
    }

}
