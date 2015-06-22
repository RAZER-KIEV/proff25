package hw5.users;

import java.sql.*;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * * Написать приложение, позволяющее добавлять нового пользователя и просматривать список существующих пользователей. Структура таблицы (id, имя, пароль, дата).
 * Created by RAZER on 11.06.2015.
 */
public class MainWindow {
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(Locale.UK);
        User user1 = new User(001,"Sviatoslav","123abc","11-06-2015");
        UserJDBCManager userJDBCManager = new UserJDBCManager();
        userJDBCManager.create(user1);






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
        int userId = user.getId();
        String userName = user.getName();
        String userPass = user.getPass();
        String userRegDate = user.getDate();
        StringBuilder sb =new StringBuilder();
        sb.append("INSERT INTO hw5 (userid,username,pass,regdate) VALUES (");
        sb.append(userId + ",'" + userName + "','" + userPass + "','" + userRegDate + "')");
        String reqestSQL = sb.toString();
        System.out.println(reqestSQL);
        int res = stmt.executeUpdate(reqestSQL);
           return res;
    }
    public List<User> findAll() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
        boolean rsnxt;
        do{
            rsnxt = rs.next();
            int id = rs.getInt(1);
            System.out.print("id:  "+id+",  ");

            String str1 = rs.getString(2);
            System.out.print("Name: "+str1+",  ");

            String pass = rs.getString(3);
            System.out.print("Pass:  "+pass + ",  ");

            String regDate = rs.getString(6);
            System.out.print("Reg Date: "+regDate + ",  ");

            User tmp = new User(id,str1,pass,regDate);
            userList.add(tmp);

        }while (rsnxt);

      return userList;
    }

}
class User{
    //(id, имя, пароль, дата).
    private int id;
    private String name;
    private String pass;
    private String date;

public User(){}

public User(int id,String name,String pass, String date){
    this.id = id;
    this.name = name;
    this.pass = pass;
    this.date = date;
}
public int getId(){
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