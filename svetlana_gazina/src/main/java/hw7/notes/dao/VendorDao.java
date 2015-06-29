package hw7.notes.dao;

import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by Sveta on 6/26/2015.
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long ig);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List findAll();
}
