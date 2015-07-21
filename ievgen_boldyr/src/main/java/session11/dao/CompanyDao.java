package session11.dao;

import session11.domain.Company;

import java.util.List;

/**
 * Created by nucleos on 13.12.14.
 */

public interface CompanyDao {
    Long create(Company company);
    Company read(Long id);
    boolean update(Company company);
    boolean delete(Company company);
    List<Company> findAll();
}
