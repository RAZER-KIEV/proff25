package session11;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna on 22.06.2015.
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory sessionFactory;

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Long create(Employee employee) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(employee);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();

        } finally {
            if (session != null)
                session.close();
        }

        return null;
    }

    @Override
    public Employee read(String id) {
        return null;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public List<Employee> findAll(String companyName) {
        Session session = null;
        List<Employee> employees = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            employees = session.createCriteria(Employee.class).createCriteria("company").add(Restrictions.eq("name", companyName)).list();
            return employees;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    @Override
    public List<Employee> findByIdAge(String id, Long age) {
        return null;
    }
}
