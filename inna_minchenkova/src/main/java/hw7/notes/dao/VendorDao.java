package hw7.notes.dao;

import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public interface VendorDao {
    public Long create(Vendor vendor);
    public Vendor read(Long id);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    public List<Vendor> findAll();
}
