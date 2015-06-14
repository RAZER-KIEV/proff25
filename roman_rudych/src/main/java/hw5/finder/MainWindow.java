package hw5.finder;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by roman_rudych on 13.06.2015.
 * 3. Поиск файла в БД
 Написать приложение, осуществляющее поиск файла в файловой
 системе с сохранением результата в таблице базы данных.
 Структура таблицы (id, дата, путь)

 Классы задания:
 hw5.finder.MainWindow
 hw5.finder.PathJDBCManager
 hw5.finder.Path
 hw5.finder.FileService

 В класс PathJDBCManager поместите все операции с базой данных.

 public int create(Path user)
 public List<Path> findAll()

 FileService
 public List<Path> findAll()
 */
public class MainWindow {
    public static void main(String[] args) throws SQLException {
        FileService fs = new FileService(".mkv", "/K:/Video/");
        List<Path> list = fs.findAll();
        System.out.println(list);
        PathJDBCManager db = new PathJDBCManager();
        for(Path path : list) {
            db.create(path);
        }
        for(Path p : db.findAll()) {
            System.out.println(p);
        }
    }
}
