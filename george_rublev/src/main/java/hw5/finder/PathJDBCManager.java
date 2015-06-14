package hw5.finder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by george on 11.06.15.
 */
public class PathJDBCManager {

    public List<Path> list = new ArrayList<>();
    private Connection connect;

    public PathJDBCManager() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
    }
//
    public int create(Path user){
        try {
            PreparedStatement pprdstmnt = connect.prepareStatement("INSERT INTO PATHS(ID, FILE_DATA, PATH)VALUES(?, ?, ?)");
            pprdstmnt.setInt(1, user.getId());
            pprdstmnt.setDate(2, Date.valueOf(user.getDate()));
            pprdstmnt.setString(3, user.getFilePath());
            pprdstmnt.executeUpdate();
            return 1;
        } catch (SQLException except){
            return 0;
        }
    }
public List<Path> findAll(){
    List<Path> pathList = new ArrayList<>();
    try {
        Statement statement = connect.createStatement();
        ResultSet resultSetCheck = statement.executeQuery("SELECT * FROM PATHS");
        while (resultSetCheck.next()){
            pathList.add(new Path(resultSetCheck.getInt(1),resultSetCheck.getString(2),resultSetCheck.getString(3)));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return pathList;

}
}
