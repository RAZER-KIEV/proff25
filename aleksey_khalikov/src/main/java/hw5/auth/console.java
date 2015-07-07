package hw5.auth;



import java.sql.SQLException;
import java.util.List;

/**
 * Created by GFalcon on 14.06.15.
 */
public class console {
    public static void main(String[] args) throws SQLException {
        UserJDBCManager dbm = new UserJDBCManager();
        List<User> userList = dbm.findAll();
        dbm.close();
        for (int i = 0; i < userList.size(); i++){
            System.out.println(userList.get(i).getName());
        }
    }
}
