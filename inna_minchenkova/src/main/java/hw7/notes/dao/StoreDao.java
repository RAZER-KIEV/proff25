package hw7.notes.dao;

import hw7.notes.domain.Store;

import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public interface StoreDao {
    public Long create(Store store);
    public Store read(Long id);
    public boolean update(Store store);
    public boolean delete(Store store);
    public List<Store> findAll();
}
