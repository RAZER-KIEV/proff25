package hw5.equation;

import java.sql.SQLException;

/**
 * Created by oleg on 11.06.15.
 * Пользователь вводит диапазоны коэффициентов.
 * Заполнить таблицу решениями квадратного уравнения с действительными решениями.
 */
public class MainWindow {
    public static void main(String[] args) throws SQLException {
        SolutionJDBCManager man = new SolutionJDBCManager();
        man.qss.solve(2,6,4,5,1,6);
        man.pushAll(man.findAll());
    }
}
