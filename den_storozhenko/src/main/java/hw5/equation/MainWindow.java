package hw5.equation;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by storo_000 on 11.06.2015.
 */
public class MainWindow {
    public static void main(String[] args) {
        QuadraticService quadraticService = new QuadraticService();
        quadraticService.solve(1,300,1,20,2,7);
        List<Solution> solutions = quadraticService.getSolutionList();
        if (solutions.size()>=10000)
            System.out.println("Слишком большой диапазон");
        else {
            SolutionJDBCManager solutionJDBCManager = null;
            try {
                solutionJDBCManager = new SolutionJDBCManager();
                for (Solution solution : solutions) {
                    solutionJDBCManager.create(solution);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
