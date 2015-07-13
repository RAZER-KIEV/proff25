package session11;

import java.util.List;

/**
 * Created by Inna on 22.06.2015.
 */
public interface EmployeeDao {
    Long create(Employee employee);

    Employee read(String id);

    boolean update(Employee employee);

    void delete(Employee employee);

    public List<Employee> findAll(String companyName);

    public List<Employee> findByIdAge(String id, Long age);

}
