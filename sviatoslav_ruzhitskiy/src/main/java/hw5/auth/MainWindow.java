package hw5.auth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


/**
 * Написать приложение выполняющее аутентификацию пользователя на основе учётной записи созданнной в предыдущем задании. Если пользователь зарегистрирован, то выводим список зарегистрированных пользователей, если нет, выводим "Неправильный логин или пароль"

 public int create(User user)
 public List<User> findAll()
 public User readByNamePass(String login, String pass)

 Классы задания:
 hw5.auth.MainWindow
 hw5.auth.UserJDBCManager
 hw5.auth.User
 *
 Created by RAZER on 11.06.2015.
 */
public class MainWindow {
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(Locale.UK);
        User user1 = new User("001","Sviatoslav","123abc","11-06-2015");
        UserJDBCManager userJDBCManager = new UserJDBCManager();
        userJDBCManager.create(user1);

        System.out.println("Enter your login: ");
        Scanner in = new Scanner(System.in);
        String login = in.nextLine();
        System.out.println("Enter password: ");
        String password = in.nextLine();
        userJDBCManager.readByNamePass(login,password);




    }
}
class UserJDBCManager{
    Connection conn = null;
    List<User> userList;
    int res=0;
    Statement stmt;
    ResultSet rs;
    User user;

    public UserJDBCManager() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            System.out.println(conn);
        } catch (SQLException sqlEx)  { sqlEx.printStackTrace();  }
        stmt = conn.createStatement();

    }

    public int create(User user) throws SQLException {
        this.user = user;
        String userId = user.getId();
        String userName = user.getName();
        String userPass = user.getPass();
        String userRegDate = user.getDate();
        StringBuilder sb =new StringBuilder();
        sb.append("INSERT INTO users (userid,username,pass,regdate) VALUES (");
        sb.append(userId + ",'" + userName + "','" + userPass + "','" + userRegDate + "')");
        String reqestSQL = sb.toString();
        System.out.println(reqestSQL);
        int res = stmt.executeUpdate(reqestSQL);
        return res;
    }
    public List<User> findAll() throws SQLException {
        userList =new ArrayList<>();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
        boolean rsnxt;
        do{
            rsnxt = rs.next();
            String id = rs.getString(1);
            System.out.print("id:  "+id+",  ");

            String str1 = rs.getString(2);
            System.out.print("Name: "+str1+",  ");

            String pass = rs.getString(3);
            System.out.print("Pass:  "+pass + ",  ");

            String regDate = rs.getString(4);
            System.out.println("Reg Date: "+regDate + ",  ");

            User tmp = new User(id,str1,pass,regDate);

            userList.add(tmp);

        }while (rsnxt);

        return userList;
    }
    public User readByNamePass(String login, String pass) throws SQLException {

        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
        boolean rsnxt;
        do {
            rsnxt = rs.next();
           String log = rs.getString("USERNAME");
            if(log.equals(login)) {
                String pas = rs.getString("PASS");
                if (pas.equals(pass)) {
                    String id = rs.getString(1);
                    String regDate = rs.getString(4);

                   user = new User(id,log,pas,regDate);
                    findAll();


                }
            }
           }while (rsnxt);

      return user;
    }

}
class User{
    //(id, имя, пароль, дата).
    private String id;
    private String name;
    private String pass;
    private String date;

    public User(){}

    public User(String id,String name,String pass, String date){
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.date = date;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPass(){
        return pass;
    }
    public String getDate(){
        return date;
    }
}