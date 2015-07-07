package session14.dao;

import session11.domain.Employee;

import java.util.List;

/**
 * Created by ivan on 23.06.15.
 */
public interface EmployeeDao {

    Long create(session14.domain.Employee employee);

    session14.domain.Employee read(Long id);// Be careful!

    boolean update(session14.domain.Employee employee);

    boolean delete(session14.domain.Employee employee);

    List showAllwithCompanies();

}
