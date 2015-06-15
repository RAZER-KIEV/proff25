package hw5.finder;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by Sveta on 6/13/2015.
 Написать приложение, осуществляющее поиск файла в файловой системе с сохранением результата в таблице базы данных.
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
public class PathJDBCManager {
    public static void main(String[] args) throws SQLException {

        Locale.setDefault(Locale.ENGLISH);

        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement statement = conn.createStatement();
        String sql = "CREATE TABLE paths("
                + "solution_id NUMBER(5) NOT NULL, "
                + "creating_date DATE NOT NULL, "
                + "path VARCHAR(20) NOT NULL, "
                + "PRIMARY KEY (solution_id)"
                + ")";
        System.out.println(sql);
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        conn.close();
    }

}
