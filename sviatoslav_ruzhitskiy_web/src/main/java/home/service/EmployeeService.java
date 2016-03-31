package home.service;

import home.domain.Employee;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
public interface EmployeeService {
    Long create(Employee empl);
    Employee read(Long id);
    boolean update(Employee empl);
    boolean delete(Employee empl);
    Employee searchByLogin(String login);
    Long getDBSize();
    List findAll();
    List findAllwithNetwork(Long networkId);
}
