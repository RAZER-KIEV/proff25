package session11.dao;

import session11.domain.Employee;

import java.util.List;

/**
 * Created by nucleos on 13.12.14.
 */
public interface EmployeeDao {
    Long create(Employee employee);
    Employee read(Long id);
    boolean update(Employee employee);
    boolean delete(Employee employee);
    List<Employee> findAll();

}
