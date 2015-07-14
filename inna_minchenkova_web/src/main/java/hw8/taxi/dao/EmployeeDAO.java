package hw8.taxi.dao;

import hw8.taxi.domain.Employee;

/**
 * Created by Vlad on 04.04.2015.
 */
public interface EmployeeDAO {
    public void createEmployee(Employee employee);

    public Employee readEmployee(Long id);

    public void deleteEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public Employee getByLogin(String login);


}
