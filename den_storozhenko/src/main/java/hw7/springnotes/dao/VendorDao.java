package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;

import java.util.List;

public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long id);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List getVendorsPorced(int start, int size);
    List findAll();
}
