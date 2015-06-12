package hw5.finder;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by oleg on 11.06.15.
 */
public class FileService {
    public List<Path> list = new ArrayList<>();
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private int number = 1;
    public File root = new File("//home/oleg/");
    public List<Path> findAll() {
        return list;
    }
    public void addPath(File file){
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    addPath(f);
                } else if (f.isFile()) {
                    if (f.getName().equals(fileName)) {
                        list.add(new Path(number++, new Date(Calendar.getInstance().getTimeInMillis()), f.getPath()));
                    }
                }
            }
        }
    }
}
