package hw5.equation;

import java.sql.SQLException;

/**
 * Created by Sveta on 6/13/2015.
 */
public class MainWindow {
    public static void main(String[] args) throws SQLException {
        QuadraticService quadraticService = new QuadraticService();
        quadraticService.solve(2, 10, 3, 5, 5, 8);
    }
}
