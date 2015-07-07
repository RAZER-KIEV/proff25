package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 * Long create(Store store)
 * Store read(Long id)
 * boolean update(Store store)
 * boolean delete(Store store)
 * List findAll()
 */
public interface StoreDao {

    Long create(Store store);

    Store read(Long id);

    boolean update(Store store);

    boolean delete(Store store);

    List findAll();

}
