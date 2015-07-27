package hw5.finder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 26.07.15.
 */
public class FileService {

    private ArrayList<Path> pathes;

    public ArrayList<Path> getPathes() {
        return pathes;
    }

    public void setPathes(ArrayList<Path> pathes) {
        this.pathes = pathes;
    }

    public FileService() {
        pathes = new ArrayList<Path>();
        System.out.println("INFO: New FileServiceManager was created.");
    }

    public List findAll(String fileName, String dirName) throws FileNotFoundException {
        File searchDirectory = new File(dirName);
        if (!searchDirectory.isDirectory()) {
            throw new FileNotFoundException("'" + dirName + "' is not a directory.");
        }
        if (fileName.length() == 0) {
            throw new IllegalArgumentException("File name must be non-empty.");
        }
        search(fileName, searchDirectory);
        if (pathes.size() == 0) {
            System.out.println("There are no such files in directory " + dirName + ".");
        }
        return pathes;
    }

    private void search(String fileName, File searchDirectory) {
        if (searchDirectory.canRead()) {
            for (File tmp : searchDirectory.listFiles()) {
                if (tmp.isDirectory()) {
                    search(fileName, tmp);
                }
                if ((tmp.getName().toString()).equalsIgnoreCase(fileName)) {
                    pathes.add(new Path(tmp.getAbsolutePath(), new Date()));
                }
            }

        }
    }

    public static void main(String[] args) {
    }


}
