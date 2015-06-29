package hw7.notes.dao;

import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by george on 27.06.15.
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long id);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List getVendorsPorced(int start, int size);
    List findAll();
}
