package hw5.finder;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by RAZER on 12.06.2015.
 */
public class MainWindow {
    public static void main(String[] args) throws IOException, SQLException {
        Locale.setDefault(Locale.UK);

        System.out.println("Enter file name: ");
        //Scanner in = new Scanner(System.in);
        String filename = "eFS.txt";//in.nextLine();
        FileService fileService = new FileService();
        fileService.setSerchedFile(filename);
        ArrayList<Path> myPathes = (ArrayList<Path>) fileService.findAll();
        PathJDBCManager pathJDBCManager = new PathJDBCManager();
        for(Path path:myPathes){
            pathJDBCManager.create(path);
            System.out.println("Trying to add Path to DB");
        }
        pathJDBCManager.findAll();



    }
    //todo
}
class PathJDBCManager{
    Connection conn = null;
    Statement stmt;
    Path user;
    ArrayList<Path> pathList;
    //int result;
    String searchedFile;
   // public String fromUtiltoSQL(java.sql.Date sDate){}

    public void setSearchedFile(String filename){
        searchedFile = filename;
    }
    public void setList(List<Path> lst ){
     pathList = (ArrayList<Path>) lst;
    }

    public PathJDBCManager() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            System.out.println(conn);
            stmt = conn.createStatement();
        } catch (SQLException sqlEx)  { sqlEx.printStackTrace();  }


    }

    public int create(Path user) throws SQLException {
       int id = user.getId();
        String path = user.getPath();
       Date date = user.getCreationDate();
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY");
        String sDate = dateFormat.format(date);
        System.out.println(sDate);
        StringBuilder sb =new StringBuilder();
        sb.append("insert into search_result values (");
        sb.append(id + ",'" + sDate + "','" + path + "')");
        System.out.println(sb.toString());
        stmt.executeUpdate(sb.toString());
        System.out.println("Path added to DB");

        return 1;
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
        Files.walkFileTree(fileSystem.getPath("\\Users\\RAZER\\workspace"),
                new SimpleFileVisitor<java.nio.file.Path>() {
                    @Override
                    public FileVisitResult visitFile(java.nio.file.Path path, BasicFileAttributes attrs) {
                        //System.out.println(" path = " + path);
                        String tmp = String.valueOf(path.getFileName());
                        if(tmp.equals(searchedFile)){
                            System.out.println(" path = " + path);
                           Path resalt = new Path(++id, path.toString(),new Date(Calendar.getInstance().getTimeInMillis()) );
                            pathList.add(resalt);
                        }



                        return FileVisitResult.CONTINUE;
                    }
                });
        return pathList;
    }
}
