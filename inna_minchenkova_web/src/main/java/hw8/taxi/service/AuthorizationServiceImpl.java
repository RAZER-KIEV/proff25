package hw8.taxi.service;

import hw8.taxi.dao.EmployeeDAO;
import hw8.taxi.domain.Employee;
import hw8.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vlad on 06.04.2015.
 */

@Repository
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public boolean register(String login, String id, String pass) throws AuthenticationException {
        employeeDAO.createEmployee(new Employee(login, pass, id));
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public Employee getByLogin(String login) {
        return employeeDAO.getByLogin(login);
    }
}
