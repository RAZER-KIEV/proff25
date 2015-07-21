package session11.dao;

import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import session11.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session11.domain.Company;
import session11.domain.Employee;

import java.util.List;

/**
 * Created by nucleos on 13.12.14.
 */
public class CompanyDaoImpl implements CompanyDao {

    SessionFactory factory = HibernateUtil.getSessionFactory();


    @Override
    public Long create(Company company) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(company);
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
    public Company read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Company notebook = (Company) session.get(Employee.class, id);
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
    public boolean update(Company company) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(company);
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
    public boolean delete(Company company) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(company);
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
    public List<Company> findAll() {
        return factory.openSession().createCriteria(Employee.class).list();
    }

    public List<Employee> employees(String name) {
        return factory.openSession()
                .createCriteria(Employee.class)
                    .createCriteria("company")
                    .add(Restrictions.eq("company", name)).list();
    }

    public List<Employee> salaryForEmployees(String name, Double balance) {
        return factory.openSession().createCriteria(Employee.class)
                .createCriteria("balance")
                .add(Restrictions.gt("balance", Restrictions.sqlRestriction("SELECT SUM(salary) FROM employees"))).list();
        /*return factory.openSession().createCriteria(Employee.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.rowCount())
                        .add(Projections.sum("salary")))
                        .add(Projections.groupProperty("salary"))
                        .list();*/
    }

    public Double employeesBySalary(Double count) {
        return (Double) factory.openSession()
                .createCriteria(Employee.class)
                    .add(Restrictions.gt("salary", count))
                    .setProjection(Projections.projectionList()
                            .add(Projections.sum("salary"))).uniqueResult();
    }
}
