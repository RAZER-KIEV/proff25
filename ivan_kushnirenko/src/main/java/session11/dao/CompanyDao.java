package session11.dao;

import session11.domain.Company;

import java.util.List;

/**
 * Created by ivan on 23.06.15.
 */
public interface CompanyDao {
    Long create(Company company);
    Company read(Long id);
    boolean update(Company company);
    boolean delete(Company company);
    List<Company> findCompanyByName(String name);
    List findCompanyEmployees(String companyName);
}
