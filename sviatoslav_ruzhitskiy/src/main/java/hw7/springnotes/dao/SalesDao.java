package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;

import java.util.List;
import java.util.Map;

/**
 * Created by ПК on 25.06.2015.
 */
public interface SalesDao {
    Long create(Sales store);
    Sales read(Long ig);
    boolean update(Sales store);
    boolean delete(Sales store);
    List findAll();
    Map getSalesByDays();
}
