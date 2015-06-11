package session8;

import java.sql.*;
import java.util.Locale;

/**
 * Created by RAZER on 09.06.2015.
 */
public class Jdbc {
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(Locale.UK);
        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES  ");

            boolean rsnxt;

             do{
                rsnxt = rs.next();
                 String str2 = rs.getString(2);
                 System.out.print("name:  "+str2+",  ");

                 String str = rs.getString(3);
                 System.out.print("Second name: "+str+",  ");

                 String depId = rs.getString(11);
                 System.out.print("Department ID:  "+depId + ",  ");

                 String dateHire = rs.getString(6);
                 System.out.print("Hire Date: "+dateHire + ",  ");

                 Long id = rs.getLong(1);
                    System.out.println("ID  "+id);



                }while (rsnxt);

        } catch (Exception e) {

            conn.close();
        }
    }
}
