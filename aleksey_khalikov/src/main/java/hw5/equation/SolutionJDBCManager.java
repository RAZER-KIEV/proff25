package hw5.equation;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class SolutionJDBCManager {
    private Statement statement;


    public SolutionJDBCManager() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
    }

    public void clearTable() throws SQLException {
        Connection connection = createStatement();
        statement.executeUpdate("DELETE FROM EQUATIONS");
        closeConnection(connection);
    }

    public int create(Solution solution) throws SQLException {
        Connection connection = createStatement();

        String query = "SELECT * FROM EQUATIONS WHERE (KOEF_A='"+solution.getKoefA()+"' AND KOEF_B='"+solution.getKoefB()+
                "' AND KOEF_C='"+solution.getKoefC()+"' AND RES_1='"+solution.getRes1()+"' AND RES_2='"+solution.getRes2()+"')";
        if (!statement.executeQuery(query).next()){
            query = "INSERT INTO EQUATIONS(EQUATION_ID,KOEF_A,KOEF_B,KOEF_C,RES_1,RES_2) VALUES (EQUATIONS_SEQ.NEXTVAL,"+
                    solution.getKoefA()+","+solution.getKoefB()+","+solution.getKoefC()+","+solution.getRes2()+","+
                    solution.getRes2()+")";
            statement.executeUpdate(query);
            closeConnection(connection);
            return 1;
        }
        closeConnection(connection);
        return -1;
    }


    public List<Solution> findAll() throws SQLException {
        Connection connection = createStatement();
        List<Solution> solutions = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM EQUATIONS");
        while (resultSet.next()){
            solutions.add(new Solution(resultSet.getInt("KOEF_A"),resultSet.getInt("KOEF_B"),resultSet.getInt("KOEF_C"),
                    resultSet.getDouble("RES_1"),resultSet.getDouble("RES_2")));
        }

        closeConnection(connection);
        return solutions;
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
