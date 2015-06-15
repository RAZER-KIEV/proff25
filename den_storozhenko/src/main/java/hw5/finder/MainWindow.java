package hw5.finder;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainWindow {
    public static void main(String[] args) {
        try {
            PathJDBCManager pathJDBCManager = new PathJDBCManager();

            System.out.println("Enter fileName to search:");
            Scanner scanner = new Scanner(System.in);

            FileService fileService = new FileService(scanner.nextLine());
            fileService.findAll();

            List<Path> paths = pathJDBCManager.findAll();

            for (Path path:paths){
                System.out.println(path.getPath());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
