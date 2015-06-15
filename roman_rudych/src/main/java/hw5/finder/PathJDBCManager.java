package hw5.finder;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Роман on 13.06.2015.
 */
public class PathJDBCManager {

    public int create(Path user) throws SQLException{
        int result;
        Locale.setDefault(Locale.ENGLISH);
        Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement stmt = connect.createStatement();
        ResultSet res = stmt.executeQuery("SELECT path_id, path_file FROM paths");

        int lastId=0;
        int currentId;
        while(res.next()) {
            if(res.getString("path_file").equalsIgnoreCase(user.getPath())) {
                return -1;
            }
            currentId = res.getInt("path_id");
            if(currentId > lastId) {
                lastId = currentId;
            }
        }
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateS = sdf.format(date.getTime());

        result = stmt.executeUpdate("INSERT INTO paths VALUES ('"+(lastId+1)+"', TO_DATE('"+dateS+"' , 'dd-mm-yyyy hh24:mi:ss'), '"+user.getPath()+"')");
        return result;
    }
    public List<Path> findAll() throws SQLException {
        List<Path> list = new ArrayList<>();
        Locale.setDefault(Locale.ENGLISH);
        Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        Statement stmt = connect.createStatement();
        ResultSet res = stmt.executeQuery("SELECT path_file FROM paths");

        while(res.next()){
            list.add(new Path(res.getString(1)));
        }
        return list;
    }
}
