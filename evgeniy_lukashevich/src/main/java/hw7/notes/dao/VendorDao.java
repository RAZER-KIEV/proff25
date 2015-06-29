package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import java.util.List;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long id);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List findAll();
}
