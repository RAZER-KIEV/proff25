package hw5.equation;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sveta on 6/13/2015.
 * Пользователь вводит диапазоны коэффициентов. Заполнить таблицу решениями квадратного уравнения с действительными решениями. Дискретность шага перебора коэфициентов возьмите 1.
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
public class QuadraticService {
    private ArrayList<Solution> solutions = new ArrayList<>();
    SolutionJDBCManager solutionManager = new SolutionJDBCManager();

    public void solve(int fromA, int toA, int fromB, int toB, int fromC, int toC) throws SQLException {
        double discr;
        double root1;
        double root2;
        for (int i = fromA; i < toA; i++) {
            for (int j = fromB; j < toB; j++) {
                for (int k = fromC; k < toC; k++) {
                    discr = Math.sqrt((j * j) - (4 * i * k));
                    root1 = (-j + discr)/2 * i;
                    root2 = (-j - discr)/2 * i;
                    solutions.add(new Solution(i, j, k, root1, root2));
                }

            }

        }

        if(solutions.size() > 10000) {
            System.out.println("Too much solutions!");
        }
        else {
            for (Solution solution: solutions){
                solutionManager.create(solution);
            }
        }

    }
}
