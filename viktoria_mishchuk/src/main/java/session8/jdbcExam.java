package session8;

import java.sql.*;
import java.util.Locale;

/**
 * Created by viktoria
 * Project:.session8
 */
public class jdbcExam {
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");

        Statement stnt = conn.createStatement();
        ResultSet res = stnt.executeQuery("SELECT FIRST_NAME,LAST_NAME,DEPARTMENT_ID,HIRE_DATE FROM HR.EMPLOYEES ");

        while (res.next()) {
//            long id = res.getLong(1);
            System.out.println(res.getString(1) + "     " + res.getString(2) + "    " + res.getString(3) + "     "+res.getString(4));
        }

        conn.close();
        res.close();

    }

}

