package session14.dao;

import session11.domain.Company;

import java.util.List;

/**
 * Created by ivan on 23.06.15.
 */
public interface CompanyDao {

    Long create(session14.domain.Company company);

    session14.domain.Company read(Long id);

    boolean update(session14.domain.Company company);

    boolean delete(session14.domain.Company company);

    List<session14.domain.Company> findCompanyByName(String name);

    List findCompanyEmployees(String companyName);

}
