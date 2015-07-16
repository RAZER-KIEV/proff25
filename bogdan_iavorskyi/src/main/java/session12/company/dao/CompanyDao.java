package session12.company.dao;

import session12.company.domain.Company;

/**
 * Created by bosyi on 23.06.15.
 */
public interface CompanyDao {
    Long create(Company company);
    Company read(Long id);
    void update(Company company);
    void delete(Company company);
}
