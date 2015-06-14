package hw5.equation;

import hw5.users.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sveta on 6/13/2015.
 *  * Пользователь вводит диапазоны коэффициентов. Заполнить таблицу решениями квадратного уравнения с действительными решениями. Дискретность шага перебора коэфициентов возьмите 1.
 * Если кол-во решений больше 10000, то выводить "Слишком большой диапазон". Структура таблицы (id, коэф_а, коэф_б, коэф_с, рез_1, рез_2)

 Классы задания:
 hw5.equation.MainWindow
 hw5.equation.SolutionJDBCManager
 hw5.equation.Solution
 hw5.equation.QuadraticService

 В класс SolutionJDBCManager поместите все операции с базой данных. Желательно в методы этого класс передовать и возвращать объекты класса Solution

 public int create(Solution solution)
 public List<Solution> findAll()


 В класс QuadraticService поместите всю логику вашего приложения по решению квадратного уравнения.

 public void solve(int fromA, int toA, int fromB, int toB, int fromC, int toC)
 */
public class SolutionJDBCManager {

    public static void main(String[] args) throws SQLException {

        Locale.setDefault(Locale.ENGLISH);

        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement statement = conn.createStatement();
        String sql = "CREATE TABLE solutions("
                + "solution_id NUMBER(5) NOT NULL, "
                + "coefficient_a NUMBER(5) NOT NULL, "
                + "coefficient_b NUMBER(5) NOT NULL, "
                + "coefficient_c NUMBER(5) NOT NULL, "
                + "root_1 DOUBLE(5) NOT NULL, "
                + "root_2 DOUBLE(5) NOT NULL, "
                + "PRIMARY KEY (solution_id)"
                + ")";
        System.out.println(sql);
        int i = statement.executeUpdate(sql);
        System.out.println(i);
    }
    int id = 0;
    public int create(Solution solution) throws SQLException {
        id++;
        Locale.setDefault(Locale.ENGLISH);
        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");

        String sql = "INSERT INTO solutions(solution_id, coefficient_a, coefficient_b, coefficient_c, root_1, root_2) VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, solution.getCoefficient_a());
        statement.setInt(3, solution.getCoefficient_b());
        statement.setInt(4, solution.getCoefficient_c());
        statement.setDouble(5, solution.getRoot_1());
        statement.setDouble(6, solution.getRoot_2());
        return 1;
}

    public List<Solution> findAll() throws SQLException {
        List<Solution> solutions = new LinkedList<>();
        Locale.setDefault(Locale.ENGLISH);

        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM solutions");

        while(resultSet.next()) {
            solutions.add(new Solution(Integer.parseInt(resultSet.getString(2)), Integer.parseInt(resultSet.getString(3)), Integer.parseInt(resultSet.getString(4)), Double.parseDouble(resultSet.getString(5)), Double.parseDouble(resultSet.getString(6))));
        }

        conn.close();
        return solutions;
    }
}
