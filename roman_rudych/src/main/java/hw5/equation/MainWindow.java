package hw5.equation;

import java.util.List;

/**
 * Created by Роман on 14.06.2015.
 * 4. Квадратное уравнение
 Пользователь вводит диапазоны коэффициентов. Заполнить таблицу решениями квадратного уравнения с действительными решениями.
 Дискретность шага перебора коэфициентов возьмите 1.
 Если кол-во решений больше 10000, то выводить "Слишком большой диапазон".
 Структура таблицы (id, коэф_а, коэф_б, коэф_с, рез_1, рез_2)

 Классы задания:
 hw5.equation.MainWindow
 hw5.equation.SolutionJDBCManager
 hw5.equation.Solution
 hw5.equation.QuadraticService

 В класс SolutionJDBCManager поместите все операции с базой данных. Желательно в методы этого класс передовать
 и возвращать объекты класса Solution
 public int create(Solution solution)
 public List<Solution> findAll()

 В класс QuadraticService поместите всю логику вашего приложения по решению квадратного уравнения.
 public void solve(int fromA, int toA, int fromB, int toB, int fromC, int toC)
 */

public class MainWindow {

    public static void main(String[] args) {
        QuadraticService  qs = new QuadraticService();
        qs.solve(1,10,1,10,10,20);
        SolutionJDBCManager db = new SolutionJDBCManager();
        List<Solution> list = qs.getList();
        if(list.size() > 10_000 ) {
            System.out.println("Range is too big");
        } else {
            for (Solution solution : list) {
                db.create(solution);
            }
        }
    }
}
