package home.dao;

import home.domain.Employee;


import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
public interface EmployeeDao {
    Long create(Employee employee);
    Employee read(Long id);
    boolean update(Employee employee);
    boolean delete(Employee employee);
    Employee searchByLogin(String login);
    Long getDBSize();
    List findAll();
    List findAllwithNetwork(Long networkId);
    List findAdmins();
    List findTechs();
    List findSuperAdmins();
}
