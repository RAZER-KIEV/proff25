package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;

import java.util.List;

/**
 * Created by Well on 03.07.2015.
 */
public interface SalesDao {

    Long create(Sales store);
    Sales read(Long id);
    boolean update(Sales store);
    boolean delete(Sales store);
    List findAll();

}
