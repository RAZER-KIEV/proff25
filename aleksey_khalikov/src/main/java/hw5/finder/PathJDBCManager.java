package hw5.finder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class PathJDBCManager {
    private Statement statement;


    public PathJDBCManager() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        statement = connection.createStatement();
    }


    public int create(Path path) throws SQLException {
        if (!statement.executeQuery("SELECT PATH FROM SEARCHES WHERE PATH='" + path.getPath() + "'").next()){
            statement.executeUpdate("INSERT INTO SEARCHES(SEARCH_ID, DATA, PATH) VALUES (SEARCHES_SEQ.NEXTVAL,TO_DATE('"
                    +new Date(Calendar.getInstance().getTimeInMillis())+"','YYYY-MM-DD'),'"+path.getPath()+"')");

            return 1;
        }
        return -1;
    }


    public List<Path> findAll() throws SQLException {
        List<Path> paths = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM SEARCHES");
        while (resultSet.next()){
            paths.add(new Path(resultSet.getString("PATH")));
        }
        return paths;
    }
}
