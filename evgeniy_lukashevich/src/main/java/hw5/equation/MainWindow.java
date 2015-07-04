package hw5.equation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Jeckgehor on 20.06.2015.
 */
public class MainWindow {
    public static void main (String[] args0) throws SQLException {
       Locale.setDefault(Locale.ENGLISH);
       System.out.println(SolutionJDBCManager.create());
    }
}

