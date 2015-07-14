package hw8.taxi.service;

import hw8.taxi.dao.EmployeeDAO;
import hw8.taxi.domain.Employee;
import hw8.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vlad on 02.04.2015.
 */
@Repository
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private EmployeeDAO employeeDAO;


    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        Employee employee = employeeDAO.getByLogin(login);
        if (employee == null || employee.isEmployeeBlock()) {
            return false;
        }
        return employee.getEmployeeLogin().equals(login) && employee.getEmployeePAssword().equals(pass);

    }


    @Override
    public void setBlock(String login) {
        Employee employee = employeeDAO.getByLogin(login);
        if (employee != null) {
            employee.setEmployeeBlock(true);
            employeeDAO.updateEmployee(employee);
        }
    }


}
