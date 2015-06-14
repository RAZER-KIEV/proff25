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
            List<Path> pathList = fileService.findAll();
            for (Path path:pathList){
                pathJDBCManager.create(path);
            }

            for (Path path:pathJDBCManager.findAll())
                System.out.println(path.getPath());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
