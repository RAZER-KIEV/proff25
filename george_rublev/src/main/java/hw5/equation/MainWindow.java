package hw5.equation;

/**
 * Created by george on 11.06.15.
 */
public class MainWindow {
    public static void main(String[] args) {
        QuadraticService quadraticService = new QuadraticService();
        quadraticService.solve(8,10,8,10,8,10);
        quadraticService.printAll();
    }
}
