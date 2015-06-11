package hw5.auth;

import java.sql.SQLException;
import java.util.Scanner;

public class MainWindow {
    public static void main(String[] args) {
        try {
            UserJDBCManager userJDBCManager = new UserJDBCManager();

            Scanner scanner = new Scanner(System.in);
            userJDBCManager.readByNamePass(scanner.nextLine(), scanner.nextLine()).print();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
