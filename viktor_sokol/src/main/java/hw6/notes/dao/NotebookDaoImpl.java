package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class NotebookDaoImpl implements NotebookDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    public NotebookDaoImpl() {
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Password1@");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long create(Notebook ntb) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO notebook (serial, vendor, model, manufacture_date,price) VALUES (? , ?, ?, ?, ?)");
            preparedStatement.setString(1, ntb.getSerial());
            preparedStatement.setString(2, ntb.getVendor());
            preparedStatement.setString(3, ntb.getModel());
            preparedStatement.setString(4, ntb.getManufactureDate());
            preparedStatement.setFloat(5, (ntb.getPrice()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return 1L;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public Notebook read(Long ig) {
        ResultSet resultSet;
        Notebook notebook = null;
        Long id = null;
        String serial = null;
        String vendor = null;
        String model = null;
        String manufactureDate = null;
        Float price = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM notebook WHERE id=" + ig);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getLong("id");
                serial = resultSet.getString("serial");
                vendor = resultSet.getString("vendor");
                model = resultSet.getString("model");
                manufactureDate = resultSet.getString("manufacture_date");
                price = resultSet.getFloat("price");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        notebook = new Notebook();
        notebook.setId(id);
        notebook.setSerial(serial);
        notebook.setVendor(vendor);
        notebook.setModel(model);
        notebook.setManufactureDate(manufactureDate);
        notebook.setPrice(price);

        return notebook;
    }

    public boolean update(Notebook ntb) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE notebook SET serial=?, vendor=?, model=?, manufacture_date=?, price=? WHERE id=" + ntb.getId());
            preparedStatement.setString(1, ntb.getSerial());
            preparedStatement.setString(2, ntb.getVendor());
            preparedStatement.setString(3, ntb.getModel());
            preparedStatement.setString(4, ntb.getManufactureDate());
            preparedStatement.setDouble(5, (ntb.getPrice()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Notebook ntb) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM notebook WHERE id=" + ntb.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Notebook> findAll() {
        ResultSet resultSet;
        Notebook notebook = null;
        List<Notebook> notebooks = new ArrayList<Notebook>();
        Long id = null;
        String serial = null;
        String vendor = null;
        String model = null;
        String manufactureDate = null;
        Float price = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM notebook");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getLong("id");
                serial = resultSet.getString("serial");
                vendor = resultSet.getString("vendor");
                model = resultSet.getString("model");
                manufactureDate = resultSet.getString("manufacture_date");
                price = resultSet.getFloat("price");

                notebook = new Notebook();
                notebook.setId(id);
                notebook.setSerial(serial);
                notebook.setVendor(vendor);
                notebook.setModel(model);
                notebook.setManufactureDate(manufactureDate);
                notebook.setPrice(price);
                notebooks.add(notebook);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notebooks;
    }
}
