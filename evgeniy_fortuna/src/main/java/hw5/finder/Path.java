package hw5.finder;

import java.util.Date;

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

public class Path {
    private Integer id;
    private String path;
    private Date date;

    Path(String path, Date date) {
        this.path = path;
        this.date = date;
    }

    Path(Integer id, String path, Date date) {
        this(path, date);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public Date getDate() {
        return date;
    }
}

