package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 * Long create(Sales store)
 * Sales read(Long ig)
 * boolean update(Sales store)
 * boolean delete(Sales store)
 * List findAll()
 */
public interface SalesDao {

    Long create(Sales store);

    Sales read(Long ig);

    boolean update(Sales store);

    boolean delete(Sales store);

    List findAll();

}
