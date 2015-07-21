package web.dao;

import web.domain.Employee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
public interface EmployeeDao {
    List<Employee> findAll();
}
