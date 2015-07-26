package session11.dao;

import session11.domain.Company;
import session11.domain.Employee;

import java.util.List;

/**
 * Created by viktoria
 * Project:.session11.dao
 */
public interface EmployeeDao {

    Long createEmployee(Employee empl);
    List<Employee> findEmpl( Company company);
    List<Object[][]> findAll();
    List<Object[][]> findBigCompany();
}
