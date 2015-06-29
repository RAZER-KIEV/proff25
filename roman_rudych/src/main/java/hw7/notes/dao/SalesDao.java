package hw7.notes.dao;

import hw7.notes.domain.Sales;

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
