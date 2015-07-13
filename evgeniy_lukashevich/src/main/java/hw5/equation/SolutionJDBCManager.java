package hw5.equation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Jeckgehor on 30.06.2015.
 */
class SolutionJDBCManager {
    public static int create() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement stmt = conn.createStatement();
        ArrayList<Double> al = Solution.solve(-8, 8, -4, 4, -10, 10);
        int count = 0;
        System.out.println(al);
        for (int i = 0; i < al.size(); i+=5) {
            String str = "INSERT INTO quadratic (id, coef_a, coef_b, coef_c, root1, root2) VALUES (QUADRATIC_SEQ.nextVal, "
                    + al.get(i) + ", " + al.get(i + 1) + ", " + al.get(i + 2) + ", "
                    + al.get(i + 3) + ", " + al.get(i + 4) + ")";
            stmt.executeUpdate(str);
            System.out.println(str);
            count++;
        }
        conn.close();
        return count;
    }
}
