package home.service;


import home.dao.EmployeeDao;
import home.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by ПК on 11.07.2015.
 */

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {


   private Integer maxWrongPasses=5;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public boolean authenticate(String login, String pass)  {

        Employee employee = employeeDao.searchByLogin(login);
        if(employee!=null){
        if (!employee.getBlocked() & employee.getPassword().equals(pass)) {
            return true;
        } else {
            employee.setWrongPass(employee.getWrongPass() + 1);
            if(employee.getWrongPass()>= maxWrongPasses) {
                employee.setBlocked(true);
                employeeDao.update(employee);
                }
            }
        }
        return false;
    }
    @Override
    public Long create(Employee employee) {
        return employeeDao.create(employee);
    }

    @Override
    public Employee read(Long id) {
        return employeeDao.read(id);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public boolean delete(Employee employee) {
        return employeeDao.delete(employee);
    }

    @Override
    public Employee searchByLogin(String login) {
        return employeeDao.searchByLogin(login);
    }

    @Override
    public List findAll() {
        return employeeDao.findAll();
    }


}
