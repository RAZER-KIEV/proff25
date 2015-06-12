package hw5.finder;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Created by RAZER on 12.06.2015.
 */
public class MainWindow {
    public static void main(String[] args) {
        System.out.println("Enter file name: ");
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();

    }
    //todo
}
class PathJDBCManager{
    List<Path> pathList;
    int resalt;
    public int create(Path user){
        //todo
        return resalt;
    }
    public List<Path> findAll(){
      //todo
        return pathList;
    }

}
class Path{
    //prepare object to SQL
    int id;
    String path;
    Date creationDate;
    public  Path(int id,String path,Date creationDate){
        this.id = id;
        this.path = path;
        this.creationDate = creationDate;
    }
    public int getId(){return id;}
    public String getPath(){return path;}
    public Date getCreationDate(){return creationDate;}

//todo
}
class FileService {
    List<Path> pathList;
    FileSystem fileSystem;
    String searchedFile;
    int id;

    public List<Path> getList(){return pathList;}

    public void setSerchedFile(String fName){
        searchedFile = fName;
    }
   // public void addPath(java.nio.file.Path path) {
      //todo  pathList.add()
    //}

    public List<Path> findAll() throws IOException {
        id=0;
        pathList = new ArrayList<Path>();
        fileSystem = FileSystems.getDefault();
        /*final java.nio.file.Path path = */
        Files.walkFileTree(fileSystem.getPath("\\Users\\RAZER"),
                new SimpleFileVisitor<java.nio.file.Path>() {
                    @Override
                    public FileVisitResult visitFile(java.nio.file.Path path, BasicFileAttributes attrs) {
                        System.out.println(" path = " + path);
                        String tmp = String.valueOf(path.getFileName());
                        if(tmp.equals(searchedFile)){

                           Path resalt = new Path(++id, path.toString(),new Date(Calendar.getInstance().getTimeInMillis()) );
                            pathList.add(resalt);
                        }



                        return FileVisitResult.CONTINUE;
                    }
                });
        return pathList;
    }
}
