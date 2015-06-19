package hw5.equation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by george on 11.06.15.
 */
public class SolutionJDBCManager {
    private Statement statement;
    private Connection connection;

    public SolutionJDBCManager() {
        Locale.setDefault(Locale.ENGLISH);
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int create(Solution solution){
        try {
            Statement pstmnt = connection.createStatement();
            ResultSet rs=pstmnt.executeQuery("INSERT INTO EQUATION(A, B, C, X1, X2) VALUES (' " +
                    solution.getA() + " ',' " +
                    solution.getB() + "', '" +
                    solution.getC() + "', '" +
                    solution.getX1() + "', '" +
                    solution.getX2() + "')");
        } catch (SQLException sqlEx){
            return 0;
        }
        return  1;

    }
    public List<Solution> findAll(){
        List<Solution> list = new ArrayList<>();
        ResultSet resultat = null;
        try {
            resultat = statement.executeQuery("SELECT * FROM EQUATION");
            while (resultat.next()) {
                int a = resultat.getInt("A");
                int b = resultat.getInt("B");
                int c = resultat.getInt("C");
                int x1 = resultat.getInt("X1");
                int x2 = resultat.getInt("X2");
                list.add(new Solution(a,b,c,x1,x2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
