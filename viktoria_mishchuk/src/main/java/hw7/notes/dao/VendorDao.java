package hw7.notes.dao;

import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw7.notes.dao
 */
public interface VendorDao {

    Long create(Vendor vendor);
    Vendor read(Long ig);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List findAll();

}
