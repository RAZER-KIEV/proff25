package hw7.notes.dao;

import hw7.notes.domain.Sales;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw7.notes.dao
 */
public interface SalesDao {

    Long create(Sales store);
    Sales read(Long ig);
    boolean update(Sales store);
    boolean delete(Sales store);
    List findAll();
}
