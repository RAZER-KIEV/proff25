package hw5.equation;

import java.sql.*;
import java.util.List;
import java.util.Locale;

/**
 * Created by oleg on 11.06.15.
 */
public class SolutionJDBCManager {
    private Statement stmnt;
    private Connection conn;
    private Path path;
    QuadraticService qss = new QuadraticService();
    public Solution solution;
    List<Solution> solutionList;
    public SolutionJDBCManager() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        stmnt = conn.createStatement();
    }

    public int creat(Solution solution) throws SQLException {
        try {
            PreparedStatement pstmnt = conn.prepareStatement("INSERT INTO EQUATION(ID, KOEF_A, KOEF_B, KOEF_C, RES_1, RES_2) VALUES (?, ?, ?, ?, ?, ?)");
            pstmnt.setInt(1, solution.getId());
            pstmnt.setInt(2, solution.getKoef_a());
            pstmnt.setInt(3, solution.getKoef_b());
            pstmnt.setInt(4, solution.getKoef_c());
            pstmnt.setInt(5, solution.getRes_1());
            if(solution.getRes_2()!=null) {
                pstmnt.setInt(6, solution.getRes_2());
            }    else   {
                pstmnt.setInt(6, ' ');
            }
            pstmnt.executeUpdate();
            return 1;
        } catch (SQLException except){
            return 0;
        }
    }

    public int create(Path path) throws SQLException {
        try {
            PreparedStatement pstmnt = conn.prepareStatement("INSERT INTO EQUATION(ID, KOEF_A, KOEF_B, KOEF_C, RES_1, RES_2) VALUES (?, ?, ?, ?, ?, ?)");
            pstmnt.setInt(1, solution.getId());
            pstmnt.setInt(2, solution.getKoef_a());
            pstmnt.setInt(3, solution.getKoef_b());
            pstmnt.setInt(4, solution.getKoef_c());
            pstmnt.setInt(5, solution.getRes_1());
            if(solution.getRes_2()!=null) {
                pstmnt.setInt(6, solution.getRes_2());
            }    else   {
                pstmnt.setInt(6, ' ');
            }
            pstmnt.executeUpdate();
            return 1;
        } catch (SQLException except){
            return 0;
        }
    }


    public List<Solution> findAll(){
        return qss.list;
    }

    public void pushAll(List<Solution> list) throws SQLException {
        for (Solution sol : list){
            System.out.println(creat(sol));
        }
    }
}
