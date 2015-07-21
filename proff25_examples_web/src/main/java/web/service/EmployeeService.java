package web.service;

import web.domain.Employee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.03.15
 */
public interface EmployeeService {
    List<Employee> findAll();
}
