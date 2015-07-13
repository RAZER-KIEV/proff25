package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;

import java.util.List;

/**
 * Created by Роман on 25.06.2015.
 */
public interface SalesDao {
    Long create(Sales sales);
    Sales read(Long ig);
    boolean update(Sales sales);
    boolean delete(Sales sales);
    List<Sales> findAll();
}
