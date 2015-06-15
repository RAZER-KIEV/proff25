package hw5.finder;

import java.io.File;
import java.sql.SQLException;
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

    private void findFile(String path) throws SQLException {
        PathJDBCManager pathJDBCManager = new PathJDBCManager();
        Path path1;

        File from = new File(path);
        File[] files = from.listFiles();
        if (files!=null) {
            for (File f : files) {
                if (f.getName().equals(searchedFileName)) {
                    path1 = new Path(f.getAbsolutePath());
                    paths.add(path1);
                    pathJDBCManager.create(path1);
                } else {
                    if (f.isDirectory()) {
                        findFile(path + "\\" + f.getName());
                    }
                }
            }
        }
    }

    public List<Path> findAll() throws SQLException {
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

    public void setSearchedFileName(String searchedFileName) {
        this.searchedFileName = searchedFileName;
    }

    public void setPathToSearch(String pathToSearch) {
        this.pathToSearch = pathToSearch;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public String getSearchedFileName() {
        return searchedFileName;
    }

    public String getPathToSearch() {
        return pathToSearch;
    }

    public List<Path> getPaths() {
        return paths;
    }
}
