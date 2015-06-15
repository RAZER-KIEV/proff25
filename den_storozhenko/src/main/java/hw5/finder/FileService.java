package hw5.finder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private String searchedFileName;
    private String pathToSearch;
    private List<Path> paths;

    public FileService(String file) {
        this.searchedFileName = file;
        paths = new ArrayList<>();
        pathToSearch = "";
    }

    public FileService(String file, String path){
        searchedFileName = file;
        pathToSearch = path;
    }

    private void findFile(String path){
        File from = new File(path);
        File[] files = from.listFiles();
        if (files!=null) {
            for (File f : files) {
                if (f.getName().equals(searchedFileName)) {
                    paths.add(new Path(f.getAbsolutePath()));
                } else {
                    if (f.isDirectory()) {
                        findFile(path + "\\" + f.getName());
                    }
                }
            }
        }
    }

    public List<Path> findAll(){
        if (pathToSearch.equals("")) {
            File[] roots = File.listRoots();
            for (File file : roots) {
                if (!file.getPath().equals("C:\\"))
                    findFile(file.getPath());
            }
        } else {
            findFile(pathToSearch);
        }
        return paths;
    }

    public void  print (){
        for (Path path:paths)
            System.out.println(path.getPath());
    }
}
