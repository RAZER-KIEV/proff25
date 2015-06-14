package session7_8;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Sveta on 6/9/2015.
 */
public class Country {
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);

        System.out.println("Enter Country: ");
        Scanner scanner = new Scanner(System.in);
        String country;
        String region;
           country = scanner.nextLine();
        System.out.println("Enter Region: ");
            region = scanner.nextLine();

        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement statement = conn.createStatement();
        String sql = "INSERT INTO countries(country_id, country_name, region_id) VALUES('UA', '" + country +"', " + Integer.parseInt(region) + ")";
        System.out.println(sql);
        int i = statement.executeUpdate(sql);
        System.out.println(i);





    }
}
