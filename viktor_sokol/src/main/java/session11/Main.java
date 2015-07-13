package session11;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Віктор on 6/22/2015.
 */
public class Main {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mysql";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Password1@";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Company company = new Company("Semka", 10000D);


        NotebookDaoImpl notebookDao = new NotebookDaoImpl();
        notebookDao.getConnection();


    }
}
