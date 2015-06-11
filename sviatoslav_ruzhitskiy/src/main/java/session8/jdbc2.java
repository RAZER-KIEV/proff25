package session8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by RAZER on 09.06.2015.
 */
public class jdbc2 {
    public static void main(String[] args) {
        System.out.println("ВВедите Страну");
        Scanner in = new Scanner(System.in);
        String country = in.next();

        Locale.setDefault(Locale.UK);

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            int upRess = stmt.executeUpdate("INSERT INTO ");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}