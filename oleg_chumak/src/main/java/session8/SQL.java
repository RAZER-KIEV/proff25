package session8;


import java.sql.*;
import java.util.*;

/**
 * Created by oleg on 09.06.15.
 */
public class SQL {
    public static void main(String[] args) throws SQLException {

        Locale.setDefault(Locale.ENGLISH);
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr", "hr");
        System.out.println(conn);
        Statement stmnt = conn.createStatement();
//        ResultSet res = stmnt.executeQuery("SELECT * FROM COUNTRIES");
//

//        while ( res.next()) {
//            String first_name = res.getString("FIRST_NAME");
//            String last_name = res.getString("LAST_NAME");
//            java.hw6.notes.util.Date hire_date = res.getDate("HIRE_DATE");
//            Long department_id = res.getLong("DEPARTMENT_ID");
//            System.out.println(/*"%15s%15s%20d\n", */first_name + " " + last_name + " " + hire_date.toString() + " " + department_id);
//        }

//        while (res.next()){
//            int country_id = res.getInt(1);
//            String country = res.getString(2);
//            int region = res.getShort(3);
//            System.out.println(country_id+ " " +country+ " " +region);
//        }
//        System.out.println("________________________________________________");
        System.out.println(stmnt.executeUpdate("INSERT INTO COUNTRIES(COUNTRY_ID, COUNTRY_NAME, REGION_ID) VALUES ('ir', 'UKR', 1)"));
//        System.out.println(stmnt.executeUpdate("UPDATE COUNTRIES SET COUNTRY_NAME  = 'Ukraine_great' where COUNTRY_ID = 'UA'"));
//        System.out.println(stmnt.);
//        while (res.next()){
//            String country_id = res.getString(1);
//            String country = res.getString(2);
//            int region = res.getShort(3);
//            System.out.println(country_id+ " " +country+ " " +region);
//        }
    }
}
