package hw5.finder;

import java.sql.SQLException;
import java.util.List;


public class MainWindow {
    public static void main(String[] args) throws SQLException {
        PathJDBCManager man = new PathJDBCManager();
        man.fss.setFileName("build.txt");
        List<Path> paths = man.findAll();
        System.out.println(paths);
        for (Path pa : paths){
            System.out.println(man.create(pa));
        }
    }
}
