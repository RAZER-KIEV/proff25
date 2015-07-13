package hw5.equation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionJDBCManager {
    Connection conn = null;
    public int create(Solution solution){
        Statement st = null;
        int res = 0;
        try {
            st = this.conn.createStatement();
            String query = "INSERT INTO t_equation (coefa, coefb, coefc, d, x1, x2) VALUES (";
            query += solution.coefA + ",";
            query += solution.coefB + ",";
            query += solution.coefC + ",";
            query += solution.D + ",";
            if (solution.x1 != null) {
                query += solution.x1 + ",";
            } else {
                query += "null,";
            }
            if (solution.x2 != null) {
                query += solution.x2 + ")";
            } else {
                query += "null)";
            }
            System.out.println(query);
            res = st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Solution> findAll(){
        List<Solution> list = new ArrayList<>();
        String query = "SELECT coefa, coefb, coefc, d, x1, x2 FROM t_equation";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()){
                Solution sol = new Solution(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6));
                list.add(sol);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void deleteAll(){
        String query = "DELETE FROM t_equation";
        Statement st = null;
        int res = 0;
        try {
            st = conn.createStatement();
            res = st.executeUpdate(query);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean connect(){
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        try {
            this.conn = DriverManager.getConnection(url, "hr", "hr");
            return true;
        } catch (SQLException e) {
            e.getMessage();
            return false;
        }
    }
    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

