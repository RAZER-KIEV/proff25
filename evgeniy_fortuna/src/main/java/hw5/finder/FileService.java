package hw5.finder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

public class FileService extends Thread implements ActionListener {

    private File[] files;

    private JTextField file;
    private JTextField directory;

    private String fileName;
    private String startDirectory;

    PathJDBCManager jdbcManager;
    Path path;

    public FileService(JTextField file, JTextField directory) {
        this.file = file;
        this.directory = directory;
        jdbcManager = new PathJDBCManager();
    }

    public FileService(String file, String directory) {
        fileName = file;
        startDirectory = directory;
        jdbcManager = new PathJDBCManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ThreadGroup group = new ThreadGroup("FindGroup");
        fileName = file.getText();
        startDirectory = directory.getText();
        Thread thread = new Thread(group, new FileService(fileName, startDirectory));
        thread.start();

        while (group.activeCount() > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        File start = new File(startDirectory);
        if (start.isDirectory() && !start.isHidden()) {
            files = start.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    Thread findThread = new Thread(new FileService(fileName, file.getPath()));
                    findThread.start();
                } else if (file.isFile() && !file.isHidden()) {
                    if (file.getName().equals(fileName)) {
                        this.path = new Path(file.getPath(), new Date());
                        addPath(this.path);
                    }
                }
            }
        }
    }

    public int create() { return 0; }

    public List<Path> find() { return null; }

    private synchronized void addPath(Path path) {
        jdbcManager.create(path);
    }
}

