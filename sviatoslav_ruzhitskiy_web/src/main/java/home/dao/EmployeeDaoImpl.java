package home.dao;

import home.domain.Employee;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Employee tech) {
        return (Long)sessionFactory.getCurrentSession().save(tech);
    }

    @Override
    public Employee read(Long id) {
        return (Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public boolean update(Employee tech) {
        sessionFactory.getCurrentSession().update(tech);
        return true;
    }

    @Override
    public boolean delete(Employee tech) {
        sessionFactory.getCurrentSession().delete(tech);
        return true;
    }

    @Override
    public Employee searchByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee c where c.login=:login");
        query.setParameter("login",login);
        return (Employee)query.uniqueResult();
    }

    @Override
    public Long getDBSize() {
        Long size = (Long) sessionFactory.getCurrentSession().createQuery("select COUNT(c.id) from Employee c").uniqueResult();
        System.out.println("getDBSize: "+size);
        return size;
    }

    @Override
    public List findAll() {
        List<Employee> employee;
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee");
        employee = query.list();
        return employee;
    }

    @Override
    public List findAllwithNetwork(Long networkId) {
        List<Employee> employees;
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee e where e.networkId=:networkId");
        query.setParameter("networkId", networkId);
        employees = query.list();
        return employees;
    }

    @Override
    public List findAdmins() {
        List<Employee> admins;
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee e where e.position=:admin");
        query.setParameter("admin", "admin");
        admins = query.list();
        return admins;
    }

    @Override
    public List findTechs() {
        List<Employee> admins;
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee e where e.position=:tech");
        query.setParameter("tech", "tech");
        admins = query.list();
        return null;
    }

    @Override
    public List findSuperAdmins() {
        return null;
    }
}
