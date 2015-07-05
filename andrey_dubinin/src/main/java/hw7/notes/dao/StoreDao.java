package hw7.notes.dao;

import hw7.notes.domain.Store;

import java.util.List;

/**
 * Created by jax on 05.07.15.
 */
public interface StoreDao {
    Long create(Store store);
    Store read(Long id);
    Boolean update(Store store);
    Boolean delete(Store store);
    List findAll();
}
