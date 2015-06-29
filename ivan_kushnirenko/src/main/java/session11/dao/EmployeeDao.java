package session11.dao;

import session11.domain.Employee;

import java.util.List;

/**
 * Created by ivan on 23.06.15.
 */
public interface EmployeeDao {
    Long create(Employee employee);
    Employee read(Long id);// Be careful!
    boolean update(Employee employee);
    boolean delete(Employee employee);
    List showAllwithCompanies();
}
