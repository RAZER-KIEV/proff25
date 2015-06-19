package session8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * Small console application that will check if we can connect to our oracle database
 */
public class TestingSQL {
    public static void main(String[] args) {
        System.out.print("Trying to find driver\n... ");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("OK");
        } catch (ClassNotFoundException e) {
            System.out.println("FAILED");
            return;
        }
        System.out.print("Trying connect to \"jdbc:oracle:thin:@localhost:1521:XE\", \"hr\", \"hr\"\n... ");
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
            System.out.println("OK");
        } catch (SQLException e) {
            System.out.println("FAILED");
        }
    }
}
