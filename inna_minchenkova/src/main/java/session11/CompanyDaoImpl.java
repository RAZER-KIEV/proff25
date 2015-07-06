package session11;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionFactoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna on 22.06.2015.
 */
public class CompanyDaoImpl implements CompanyDao {
    private static Logger log = Logger.getLogger(CompanyDaoImpl.class);
    private SessionFactory factory;

    public CompanyDaoImpl(SessionFactory factory) {
        this.factory = factory;

    }


    @Override
    public Long create(Company company) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(company);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            log.error("Open session failed", e);
            session.getTransaction().rollback();

        }finally {
            if(session != null)
                session.close();
        }

        return null;
    }

    @Override
    public Company read(String id) {
        Session session = null;
        try {
            session = factory.openSession();
            return (Company)session.get(Company.class, id);

        }catch (HibernateException e){
            log.error("Open session failed", e);
        }finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    @Override
    public boolean update(Company company) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        }finally {
            if (session != null)
                session.close();
        }
        return false;
    }

    @Override
    public void delete(Company company) {

    }

    @Override
    public List<Company> findAll() {
        return null;
    }

    @Override
    public List<Company> findEmployee() {
        Session session = null;
        List<Company> companies = new ArrayList<>();
        try{
            session = factory.openSession();
            companies = session.createQuery("SELECT ");

        }
    }
}
