package hw5.finder;

import java.sql.SQLException;
import java.util.List;
/**
 * Created by oleg on 11.06.15.
 * Написать приложение, осуществляющее поиск файла в файловой системе с сохранением результата в таблице базы данных.
 */
public class MainWindow {
    public static void main(String[] args) throws SQLException {
        PathJDBCManager man = new PathJDBCManager();
        man.fss.setFileName("readme");
        List<Path> paths = man.findAll();
        for (Path pa : paths){
            System.out.println(man.create(pa));
        }
    }
}
