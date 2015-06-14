package hw5.finder;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by george on 11.06.15.
 */
public class MainWindow {
    public static void main(String[] args) {

        FileService fs = new FileService();
        List<Path> allFile=fs.findAll("/home/george/proff25/");

        fs.addToTable(allFile);

    }
}
