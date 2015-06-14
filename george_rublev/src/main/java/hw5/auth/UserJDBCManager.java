package hw5.auth;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by george on 11.06.15.
 */
public class UserJDBCManager {
    private Statement statement;
    private Connection connection;

    public UserJDBCManager() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        statement = connection.createStatement();
    }

    public void printUsers() throws SQLException {
        ResultSet res = statement.executeQuery("SELECT * FROM USERS");

        System.out.printf("%15s%15s%15s%20s\n", "id", "name", "password", "date");
        while (res.next()) {
            Long id = res.getLong("ID");
            String name = res.getString("NAME_USER");
            String password = res.getString("PASSWORD");
            Date date = res.getDate("REG_DATE");
            System.out.printf("%15d%15s%15s%15s\n", id, name, password, date.toString());
        }
    }

    public int create(User user){
        try {
            Statement pstmnt = connection.createStatement();
            ResultSet rs=pstmnt.executeQuery("INSERT INTO USERS(ID, NAME_USER, PASSWORD, REGISTRATION_DATE) VALUES (' " +
                    user.getId() + " ',' " +
                    user.getName() + "', '" +
                    user.getPassword() + "', '" +
                    user.getDate() + "')");
        } catch (SQLException sqlEx){
            return 0;
        }
        return  1;
    }

    public User readByNamePass(String login, String pass){
        ResultSet res = null;
        try {
            res = statement.executeQuery("SELECT * FROM USERS");
            while (res.next()) {
                if(res.getString("NAME_USER").equals(login)){
                    if (res.getString("PASSWORD").equals(pass)){
                        return new User(res.getInt("ID"), login, pass, res.getDate("REG_DATE"));
                    }
                    System.out.println("Не верный пароль.");
                }
            }
            System.out.println("Нет пользователя с таким логином.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<User> findAll(){
        List<User> list = new ArrayList<>();
        ResultSet resultat = null;
        try {
            resultat = statement.executeQuery("SELECT * FROM USERS");
            while (resultat.next()) {
                int id = resultat.getInt("ID");
                String name = resultat.getString("NAME_USER");
                String password = resultat.getString("PASSWORD");
                Date reg_date = resultat.getDate("REG_DATE");
                list.add(new User(id, name, password, reg_date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addUser(User user){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("INSERT INTO USERS(ID, NAME_USER, PASSWORD, REG_DATE) VALUES " +
                    "('" + user.getId() + "','" + user.getName() + "' ,'"  + user.getPassword() + "' , '" +
                    Date.valueOf(LocalDate.now()) + "')");
//            pstmnt.executeUpdate();
        } catch (SQLException sqlEx){
            System.out.println(sqlEx);
            System.out.println("Не могу добавить полльзователя");
        }

    }

    public int getNextId(){
        int id = -1;
        try {
            ResultSet res = statement.executeQuery("SELECT ID FROM USERS");
            while (res.next()){
                if(id<res.getInt("ID")){
                    id=res.getInt("ID");
                }
            }
            id++;
            System.out.println("ID "+id);
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("Сбой получения ID");
        }
        return id;
    }
}
