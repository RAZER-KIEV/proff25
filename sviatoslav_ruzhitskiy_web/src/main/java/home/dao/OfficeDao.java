package home.dao;

import home.domain.Office;

import java.util.List;

/**
 * Created by RAZER on 11-Mar-16.
 */
public interface OfficeDao {
    Long create(Office office);
    Office read(Long id);
    boolean update(Office office);
    boolean delete(Office office);
    List findAll(Long networkId);
}
