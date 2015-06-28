package hw7.notes.dao;

import hw7.notes.domain.Store;
import java.util.List;

/**
 * Created by GFalcon on 25.06.15.
 */
public interface StoreDao {
    Long create(Store store);
    Store read(Long ig);
    boolean update(Store store);
    boolean delete(Store store);
    List<Store> findAll();
}
