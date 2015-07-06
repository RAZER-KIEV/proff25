package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;

import java.util.List;
import java.util.Map;

public interface SalesDao {
    Long create(Sales sales);
    Sales read(Long id);
    boolean update(Sales sales);
    boolean delete(Sales sales);
    List getSalesPorced(int start, int size);
    List findAll();
    Map getSalesByDays();
}
