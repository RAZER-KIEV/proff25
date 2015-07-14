package hw8.taxi.dao;

import hw8.taxi.domain.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vlad on 04.04.2015.
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public void createEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee readEmployee(Long id) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    @Override
    public Employee getByLogin(String login) {
        return (Employee) sessionFactory.getCurrentSession()
                .createCriteria(Employee.class).add(Restrictions.eq("employeeLogin", login)).uniqueResult();
    }

}
