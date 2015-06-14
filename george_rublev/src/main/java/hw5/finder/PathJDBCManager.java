package hw5.finder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by george on 11.06.15.
 */
public class PathJDBCManager {
//    FileService fss  = new FileService();

    public List<Path> list = new ArrayList<>();
    private Connection connect;

    public PathJDBCManager() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
    }
//
    public int create(Path user){
        try {
            PreparedStatement pprdstmnt = connect.prepareStatement("INSERT INTO PATHS(ID, MAKE_DATE, PATH_FILE)VALUES(?, ?, ?)");
            pprdstmnt.setInt(1, user.getId());
            pprdstmnt.setDate(2, Date.valueOf(user.getDate()));
            pprdstmnt.setString(3, user.getFilePath());
            pprdstmnt.executeUpdate();
            System.out.println("add");
            return 1;
        } catch (SQLException except){
            return 0;
        }
    }

//    public List<Path> findAll(){
//        return fss.findAll(String.valueOf(fss.getPathList()));
//    }
}
