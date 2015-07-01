package session14;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sveta on 6/30/2015.
 */
@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao  {
    @Autowired (required = true)
    private SessionFactory factory;

    public CompanyDaoImpl() {
    }

    public CompanyDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Company> findAll() {
        Session session = factory.openSession();
        Query query =  session.createQuery("from session14.Company");

        List<Company> list = (List<Company>) query.list();
        session.close();
        return list;
    }

    @Override
    public Long create(Company comp) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(comp);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public List<Employee> findEmpsByComp(Company company) {
        return null;
    }
}
