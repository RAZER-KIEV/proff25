package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;

import java.util.List;

/**
 * Created by Роман on 25.06.2015.
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long ig);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List<Vendor> findAll();
}
