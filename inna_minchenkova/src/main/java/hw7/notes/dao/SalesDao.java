package hw7.notes.dao;

import hw7.notes.domain.Sales;

import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public interface SalesDao {
    public Long create(Sales sales);
    public Sales read(Long id);
    public boolean update(Sales sales);
    public boolean delete(Sales sales);
    public List<Sales> findAll();
}
