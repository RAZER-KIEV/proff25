package hw5.finder;

import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 *
 * Created by george on 11.06.15.
 */
public class MainWindow {
    public static void main(String[] args) {

        FileService fs = new FileService();
        List<Path> allFile=fs.findAll("/home/george/proff25/");

        fs.addToTable(allFile);
        PathJDBCManager manager = null;
        try {
            manager = new PathJDBCManager();
            List<Path> fa = manager.findAll();
            System.out.println("Print......");
            for(Path f : fa){
                System.out.println(f.getId()+"   "+f.getDate()+"  "+f.getFilePath());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
