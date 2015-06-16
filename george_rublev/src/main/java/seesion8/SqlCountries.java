package seesion8;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;


/**
 * Created by george on 09.06.15.
 */
public class SqlCountries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID");
        String id = scanner.nextLine();
        System.out.println("Введите название страны");
        String country = scanner.nextLine();
        try {
            Locale.setDefault(Locale.ENGLISH);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
//            System.out.println(connection);
            Statement statement = connection.createStatement();

            if(checkId(statement,id)){
                System.out.println("Такая запись существует");
            }else{
                ResultSet resultSet = statement.executeQuery("INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME, REGION_ID) VALUES ('"+id+"', '"+country+"', '1')");
                System.out.println("Запись добавлена.");
            }


            ResultSet resultSetUpdate = statement.executeQuery("UPDATE COUNTRIES SET COUNTRY_NAME = 'Grate Ukraine' WHERE COUNTRY_NAME = '"+country+"'");
            System.out.println("Запись изменена.");

//            while(resultSet.next()){
//                long id = resultSet.getLong(1);
//
//                System.out.println(id);
//            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkId(Statement statement, String id) {
        ResultSet resultSetCheck= null;
        try {
            resultSetCheck = statement.executeQuery("SELECT COUNTRY_ID FROM COUNTRIES");
            if(resultSetCheck.next()){
                if(id.equals(resultSetCheck.getString(1))){
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
