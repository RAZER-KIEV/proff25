package hw5.finder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Роман on 13.06.2015.
 */
public class FileService {

    private String fileName;
    private String fileRoot;

    public FileService(String fileName, String fileRoot) {
        this.fileName = fileName;
        this.fileRoot = fileRoot;
    }

    public List<Path> findAll() {
        List<Path> list = new ArrayList<>();
        File file = new File(fileRoot);
        finder(file, fileName, list);
        return list;
    }

    private void finder(File file, String fileName, List<Path> list) {
        File[] files = file.listFiles();
        if(files != null) {
            for(File f : files) {
                if(f.isDirectory()) {
                    finder(f, fileName, list);
                } else if(f.isFile()) {
                    if(f.getName().contains(fileName)) {
                        list.add(new Path(f.toString()));
                    }
                }
            }
        }
    }
}
