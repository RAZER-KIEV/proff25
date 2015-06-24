package hw7.notes.dao;

import hw7.notes.domain.Sales;
import java.util.List;

public interface SalesDao {
    Long create(Sales sales);
    Sales read(Long id);
    boolean update(Sales sales);
    boolean delete(Sales sales);
    List getSalesPorced(int start, int size);
    List findAll();
}
