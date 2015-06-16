package lection04;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Lapchenko on 09.06.2015.
 */
public class UpdateQueries {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            Statement statement = connection.createStatement();
            //statement.executeUpdate("DELETE FROM COUNTRIES WHERE (COUNTRY_ID = 'TA')");
            System.out.println("Enter ID and NAME:");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.nextLine();
            String name = scanner.nextLine();
            
            String query = "SELECT COUNTRY_ID FROM COUNTRIES WHERE COUNTRY_ID='"+id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if (!resultSet.next()){
                query = "INSERT INTO COUNTRIES(COUNTRY_ID,COUNTRY_NAME,REGION_ID) VALUES('"+id+"','"+name+"',1)";
                System.out.println(query);
                statement.executeUpdate(query);
            } else {
                query = "UPDATE COUNTRIES SET COUNTRY_NAME = '" + name + "' WHERE (COUNTRY_ID='" + id + "')";
                System.out.println(query);
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }
}

//написать приложение, которое создает страну по имени и ID региона
// пользователь вводит новое имя страны и у неё меняется имя
//добавить Украина в регион Европа и поменять Украина на Великая Украина