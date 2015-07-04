package hw7.notes.dao;

import hw7.notes.domain.Store;

import java.util.List;

/**
 * Created by Well on 03.07.2015.
 */
public interface StoreDao {

    Long create(Store store);
    Store read(Long id);
    boolean update(Store store);
    boolean delete(Store store);
    List findAll();

}
