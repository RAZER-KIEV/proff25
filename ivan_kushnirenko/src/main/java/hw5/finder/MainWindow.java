package hw5.finder;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ivan on 26.07.15.
 */
public class MainWindow {

    private PathJDBCManager pathJDBCManager;
    private FileService fileService;

    public MainWindow() {
        pathJDBCManager = new PathJDBCManager();
        fileService = new FileService();
    }

    public PathJDBCManager getPathJDBCManager() {
        return pathJDBCManager;
    }

    public void setPathJDBCManager(PathJDBCManager pathJDBCManager) {
        this.pathJDBCManager = pathJDBCManager;
    }

    public FileService getFileService() {
        return fileService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public String getData(String inputInfo) {
        System.out.println(inputInfo);
        String res = null;
        Scanner scn = new Scanner(System.in);
        while (scn.hasNext()) {
            res = scn.next();
        }
        return res;
    }

    public void createDataBase() {
        try {
            List<Path> pathes = fileService.searchFile(getData("Type file name, please."), getData("Type path to search directory, please"));
            if (pathes.size() != 0) {
                for (Path path : pathes) {
                    pathJDBCManager.create(path);
                }
            }
        } catch (FileNotFoundException exp) {
            exp.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainWindow main = new MainWindow();

    }

}


