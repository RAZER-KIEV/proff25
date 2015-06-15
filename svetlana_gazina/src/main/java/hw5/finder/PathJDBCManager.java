package hw5.finder;

import hw5.equation.Solution;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
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
        String sql = "CREATE TABLE file_path("
                + "file_id NUMBER(5) NOT NULL, "
                + "file_date DATE NOT NULL, "
                + "file_path VARCHAR(20) NOT NULL) ";
        System.out.println(sql);
        statement.execute(sql);
        statement.close();
        statement = conn.createStatement();
        sql = "CREATE SEQUENCE entry_id_seq" +
                "  START WITH 1" +
                "  INCREMENT BY 1" +
                "  CACHE 10000";
        System.out.println(sql);
        statement.execute(sql);

        statement.close();
        conn.close();
    }

    public int create(Path user) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {



            String sql = "INSERT INTO file_path(file_id, file_date, file_path) VALUES(entry_id_seq.nextval, ?, ?)";

            try(PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setDate(1, (Date) user.getDate());
                statement.setString(2, user.getPath());

                statement.execute();
                statement.close();
            }
            conn.close();
        }

        return 1;
    }

    public List<Path> findAll() throws SQLException {
        List<Path> paths = new LinkedList<>();
        Locale.setDefault(Locale.ENGLISH);

        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM file_path");

        while(resultSet.next()) {
            paths.add(new Path(resultSet.getString(3), resultSet.getDate(2)));
        }

        conn.close();
        return paths;
    }


}
