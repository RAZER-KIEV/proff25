package hw5.finder;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by george on 11.06.15.
 */
public class FileService {
    private PathJDBCManager pjdbcm;
    private List<Path> pathList = new ArrayList<>();
    private int numberPath = 0;
    private String findFilePath;
    public List<Path> list;

    public FileService() {
        try {
            pjdbcm = new PathJDBCManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FileService(String findFilePath) {
        super();
        this.findFilePath = findFilePath;
    }

    public List<Path> getPathList() {
        return pathList;
    }



    public List<Path> findAll(String findFileIn){
        String fileFind = String.valueOf(findFileIn);
        File file = new File(String.valueOf(fileFind));
        File[] findedFile = file.listFiles();

        if(findedFile != null){
            for(int i = 0 ; i<findedFile.length;i++){
                if(findedFile[i].isFile()){
                    pathList.add(
                            new Path(numberPath, String.valueOf(new Date(findedFile[i].lastModified())) ,findedFile[i].getPath())
                    );
                  numberPath++;
                }else if(findedFile[i].isDirectory()){
                    findAll(String.valueOf(findedFile[i]));
                }
            }
        }else{
            System.out.println("File error!");
        }

        return getPathList();
    }

    public void addToTable(List<Path> allFile) {
        for(Path f : pathList){
            pjdbcm.create(f);
        }
    }


}
