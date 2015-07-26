package session8;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by viktoria
 * Project:.session8
 */
public class Country {
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");

        Statement stnt = conn.createStatement();
        ResultSet res = stnt.executeQuery("INSERT INTO COUNTRIES(COUNTRY_ID,COUNTRY_NAME, REGION_ID) VALUES ('UA','UKRAINE',5)");

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите новое имя страны:");
        String newName = scan.nextLine();

//        ResultSet resUpd = stnt.executeUpdate("UPDATE COUNTRIES SET COUNTRY_NAME=newName where COUNTRY_NAME='UKRAINE'");
    }
}
