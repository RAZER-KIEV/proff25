package session11;

import java.util.List;

/**
 * Created by Sveta on 6/23/2015.
 */
public interface CompanyDao {
    Long create(Company company);
    void update(Company company);
    Company read (Long id);
    void delete (Company company);
    List<Company> findAll();
    List<String> CompaniesWithMoThanEmp(Long num);
}
