package hw5.users;

import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class MainWindow {
    public static void main(String[] args) {
        try {
            UserJDBCManager userJDBCManager = new UserJDBCManager();

            System.out.println("Enter user's name, password:");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            String password = scanner.nextLine();
            System.out.println(userJDBCManager.create(new User(name,password,new Date(Calendar.getInstance().getTimeInMillis()))));

            //userJDBCManager.delete("Petro");

            List<User> users= userJDBCManager.findAll();

            for (User user:users)
                user.print();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
