package hw5.finder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by oleg on 11.06.15.
 */
public class PathJDBCManager {
    FileService fss  = new FileService();
    private Connection connect;
    public List<Path> list = new ArrayList<>();

    public PathJDBCManager() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
    }

    public int create(Path user){
        try {
            PreparedStatement pprdstmnt = connect.prepareStatement("INSERT INTO PATHS(ID, FILE_DATA, PATH)VALUES(?, ?, ?)");
            pprdstmnt.setInt(1, user.getId());
            pprdstmnt.setDate(2, (Date) user.getDate());
            pprdstmnt.setString(3, user.getFilePath());
            pprdstmnt.executeUpdate();
            return 1;
        } catch (SQLException except){
            return 0;
        }
    }

    public List<Path> findAll(){
        return fss.list;
    }
}
