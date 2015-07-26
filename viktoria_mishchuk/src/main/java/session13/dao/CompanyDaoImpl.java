package session13.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session13.domain.Company;

import java.util.List;

/**
 * Created by viktoria
 * Project:.session13.dao
 */
public class CompanyDaoImpl implements CompanyDao{

    private SessionFactory factory;
    private Logger log = Logger.getLogger(CompanyDaoImpl.class);

    public CompanyDaoImpl(){
        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context-db.xml");

        factory = (SessionFactory) context.getBean("sf");
    }

    public CompanyDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(session13.Company company) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(company);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
        return  id;
    }

    @Override
    public Company read(Long ig){
        Session session = factory.openSession();
        try {
            return (session13.domain.Company)session.get(Company.class, ig);
        } catch (HibernateException e){
            log.error("ERROR");
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(session13.Company company) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(session13.Company company) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(company);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll(){
        Session session = factory.openSession();
        Query query = session.createQuery("from Company");
        return query.list();

    }

}
