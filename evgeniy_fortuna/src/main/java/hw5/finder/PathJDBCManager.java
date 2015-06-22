package hw5.finder;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Написать приложение, осуществляющее поиск файла в файловой системе с сохранением результата в таблице базы данных.
 * Структура таблицы (id, дата, путь)
 *
 * Классы задания:
 * hw5.finder.MainWindow
 * hw5.finder.PathJDBCManager
 * hw5.finder.Path
 * hw5.finder.FileService
 */

public class PathJDBCManager {
    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String LOGIN = "hr";
    private final String PASSWORD = "hr";
    private Connection connection;

    PathJDBCManager() {
        Locale.setDefault(Locale.ENGLISH);
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    private void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int create(Path path) {
        connect();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Statement stmt = connection.createStatement();
            System.out.println("INSERT INTO PATH VALUES ((SELECT nvl(MAX(ID),0)+1 FROM PATH), '" + path.getPath()
                    + "', TO_DATE('" + sdf.format(path.getDate()) + "', 'dd.MM.YYYY'))");
            stmt.executeUpdate("INSERT INTO PATH VALUES ((SELECT nvl(MAX(ID),0)+1 FROM PATH), '" + path.getPath()
                    + "', TO_DATE('" + sdf.format(path.getDate()) + "', 'dd.MM.yyyy'))");

        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            close();
        }
        return -1;
    }

    public List<Path> findAll() {
        return null;
    }
}

