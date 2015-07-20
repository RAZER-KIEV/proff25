package session11.dao;

import session11.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session11.domain.Employee;

import java.util.List;

/**
 * Created by nucleos on 13.12.14.
 */
public class EmployeeDaoImpl implements EmployeeDao{

    SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public Long create(Employee employee) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(employee);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            session.getTransaction().rollback();
            exc.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Employee read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Employee notebook = (Employee) session.get(Employee.class, id);
            return notebook;
        } catch (HibernateException exc) {
            session.getTransaction().rollback();
            exc.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Employee employee) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exc) {
            session.getTransaction().rollback();
            exc.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exc) {
            session.getTransaction().rollback();
            exc.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Employee> findAll() {
        return factory.openSession().createCriteria(Employee.class).list();
    }

    public List employees() {
        return null;
    }
}
