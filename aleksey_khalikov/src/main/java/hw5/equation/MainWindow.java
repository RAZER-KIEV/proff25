package hw5.equation;

import java.sql.SQLException;
import java.util.List;


public class MainWindow {
    public static void main(String[] args) throws SQLException {
        QuadraticService quadraticService = new QuadraticService();
        quadraticService.solve(1,300,1,20,2,7);
        if (quadraticService.getSolutionList().size()>=10000) {
            System.out.println("Слишком большой диапазон");
        } else {
            SolutionJDBCManager solutionJDBCManager = null;
            try {
                solutionJDBCManager = new SolutionJDBCManager();
                List<Solution> solutionList = solutionJDBCManager.findAll();

                for (Solution solution:solutionList) {
                    solution.print();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
