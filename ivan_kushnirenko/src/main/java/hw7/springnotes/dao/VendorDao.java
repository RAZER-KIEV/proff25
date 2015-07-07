package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 * Long create(Vendor vendor)
 * Vendor read(Long id)
 * boolean update(Vendor vendor)
 * boolean delete(Vendor vendor)
 * List findAll()
 */
public interface VendorDao {

    Long create(Vendor vendor);

    Vendor read(Long id);

    boolean update(Vendor vendor);

    boolean delete(Vendor vendor);

    List findAll();

}
