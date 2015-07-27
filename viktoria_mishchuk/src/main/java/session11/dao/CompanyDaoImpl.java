package session11.dao;

import hw6.notes.dao.NotebookDao;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session11.domain.Company;
import session11.domain.Employee;

import java.util.List;

/**
 * Created by viktoria
 * Project:.session11.dao
 */
public class CompanyDaoImpl implements CompanyDao{
    private static Logger log = Logger.getLogger(NotebookDao.class);
    private SessionFactory factory;

    public CompanyDaoImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<Employee> findEmpl( Company company){
        Session session = factory.openSession();
        Query query = session.createQuery("from EMPLOYEE E JOIN E.COMPANY C WHERE C.COMPANY =: comp");
        query.setParameter("comp", company);


        return query.list();
    }

    @Override
    public List<Employee> findAll(){
        Session session = factory.openSession();
        Query query = session.createQuery("from EMPLOYEE");
        return query.list();

    }

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


}
