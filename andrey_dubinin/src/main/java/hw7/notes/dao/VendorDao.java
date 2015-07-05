package hw7.notes.dao;

import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by jax on 05.07.15.
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long id);
    Boolean update(Vendor vendor);
    Boolean delete(Vendor vendor);
    List findAll();
}
