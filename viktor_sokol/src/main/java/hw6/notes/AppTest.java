package hw6.notes;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppTest {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mysql";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Password1@";

    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        notebook.setSerial("F");
        notebook.setModel("F3Jp");
        notebook.setVendor("UniversalComputers");
        notebook.setManufactureDate("12 May 2015");
        notebook.setPrice(300.0f);
        notebook.setId(1L);


        NotebookDaoImpl notebookDao = new NotebookDaoImpl();
        notebookDao.getConnection();

        notebookDao.create(notebook);
        //notebookDao.update(notebook);
        //notebookDao.read(1L);
        //notebookDao.findAll();
        //notebookDao.delete(notebook);

        notebookDao.closeConnection();

    }
}
