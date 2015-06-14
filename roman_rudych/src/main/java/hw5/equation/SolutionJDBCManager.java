package hw5.equation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Роман on 14.06.2015.
 */
public class SolutionJDBCManager {

    public int create(Solution solution) {
        Locale.setDefault(Locale.ENGLISH);
        int result = -1;
        try (
                Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
                Statement stmt = connect.createStatement();) {
            ResultSet res = stmt.executeQuery("SELECT * FROM qsolutions");
            int lastId = 0;
            int currentId;
            while (res.next()) {
                if (res.getInt("coef_a") == solution.getCoefA() && res.getInt("coef_b") == solution.getCoefB() &&
                        res.getInt("coef_c") == solution.getCoefC()) {
                    return -1;
                }
                currentId = res.getInt("solution_id");
                if (currentId > lastId) {
                    lastId = currentId;
                }
            }
            result = stmt.executeUpdate("INSERT INTO qsolutions VALUES('" + (lastId + 1) + "', '" + solution.getCoefA() + "', " +
                    "'" + solution.getCoefB() + "', '" + solution.getCoefC() + "', '" + solution.getResultOne() + "', " +
                    "'" + solution.getResultTwo() + "')");


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Solution> findAll() {

            List<Solution> list = new ArrayList<>();
            Locale.setDefault(Locale.ENGLISH);
            try ( Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
                  Statement stmt = connect.createStatement();)
            {

                ResultSet res = stmt.executeQuery("SELECT * FROM qsolutions");
                while (res.next()) {
                    list.add(new Solution(res.getInt(2), res.getInt(3), res.getInt(4), res.getDouble(5), res.getDouble(6)));
                }
            } catch (SQLException except) {
                except.printStackTrace();
            }
        return list;
    }
}
