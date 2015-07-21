package hw7.notes.dao;

import hw7.notes.domain.Sales;

import java.util.List;

public interface SalesDao {
    Long create(Sales store);
    Sales read(Long id);
    boolean update(Sales store);
    boolean delete(Sales store);
    List findAll();
}
