package session11_12;

import java.util.List;

/**
 * Created by Sveta on 6/23/2015.
 */
public interface EmployeeDao {
    Long create(Employee employee);
    void update(Employee employee);
    Employee read (Long id);
    void delete (Employee employee);
    List<Employee> findAll();
}
