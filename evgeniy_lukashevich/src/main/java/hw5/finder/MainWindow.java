package hw5.finder;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lukashevich.e on 11.06.2015.
 */
public class MainWindow {
    public static void main (String[] args) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Path path = new Path();
        path.parseAllFiles("C:\\Java\\workspace");
        String str = path.path;
        System.out.println(PathJDBCManager.create(str));
    }
}

class Path {
    String path;
    public void parseAllFiles(String str) {
        File[] filiInDirectory = new File(str).listFiles();
        for (File file : filiInDirectory){
            if (file.isDirectory()) {
                parseAllFiles(file.getAbsolutePath());
            } else {
                if (file.getName().equals("Task26.java")){
                    this.path = file.getAbsolutePath();
                }
            }
        }
    }
}

class PathJDBCManager {
    public static int create(String string) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement stmt = conn.createStatement();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = Calendar.getInstance().getTime();
        String str = "INSERT INTO files (id, date_search, path) VALUES (FILES_SEQ.nextVal,'"
                + sdf.format(date) + "', '" + string + "')";
        System.out.println(str);
        int rs = stmt.executeUpdate(str);
        return rs;
    }
}

class FileService {

}