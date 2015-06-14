package lection04;

import java.sql.*;
import java.util.Locale;

public class JdbcEx {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");
            while (resultSet.next()){
                System.out.printf("%20s%20s%20d%30tD\n", resultSet.getString("FIRST_NAME"), resultSet.getString("LAST_NAME"),
                        resultSet.getInt("DEPARTMENT_ID"), resultSet.getDate("HIRE_DATE"));
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
//вывести в консоль содержимое таблицы Employees: имя, фамилие, идентификатор департамента, дата приема
//1)выбрать всех сотрудников у которых зп от 5 до 20 тыс долл в месяц
//2)выбрать всех программистов у которых менеджер 103 и з\п больше 4000 дол в месяц
//3)выбрать всех сотрудников в именах которых есть буква Е
/**
 *
 SELECT DISTINCT *
 FROM EMPLOYEES
 WHERE (SALARY>5000 AND
 SALARY<20000);

 SELECT DISTINCT *
 FROM EMPLOYEES
 WHERE (JOB_ID = 'IT_PROG' AND
 MANAGER_ID=103 AND
 SALARY>4000);

 SELECT DISTINCT *
 FROM EMPLOYEES
 WHERE (FIRST_NAME LIKE '%e%' OR
 FIRST_NAME LIKE '%E%');
 *
 *
 */

//написать приложение, которое создает страну по имени и ID региона
// пользователь вводит новое имя страны и у неё меняется имя
//добавить Украина в регион Европа и поменять Украина на Великая Украина