package week4_lesson8;

import java.sql.*;
import java.util.Locale;

public class JDBC {
    public static void main(String[] args)  {
        Locale.setDefault(Locale.ENGLISH);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521/xe", "HR", "HR");
        Statement stat = conn.createStatement();

        //setCountry(stat);
         updtCountry(stat);
            conn.close();}

        catch (SQLException e) {
            e.printStackTrace();}
        /*  ResultSet rs = stat.executeQuery
                ("Select FIRST_NAME, LAST_NAME, DEPARTMENT_ID, HIRE_DATE  FROM EMPLOYEES");
        while (rs.next()) {
          System.out.print(rs.getString(1) + " | ");
          System.out.print(rs.getString(2) + " | ");
          System.out.print(rs.getNString(3) + " | ");
          System.out.println(rs.getDate(4));
        }*/
            }
    public static void setCountry(Statement stat) throws SQLException {
        stat.executeUpdate("INSERT INTO countries (country_id, country_name, region_id) VALUES('UA', 'Ukraine', 2) ");
    }
    public static void updtCountry(Statement stat) throws SQLException {
        stat.executeUpdate("UPDATE countries SET country_id='UA' WHERE country_id='UU' ");
    }
}