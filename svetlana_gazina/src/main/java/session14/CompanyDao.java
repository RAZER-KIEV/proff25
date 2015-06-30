package session14;

import java.util.List;

/**
 * Created by Sveta on 6/30/2015.
 */
public interface CompanyDao {
    List<Company> findAll();
    Long create(Company comp);
    List<Employee> findEmpsByComp(Company company);
}
