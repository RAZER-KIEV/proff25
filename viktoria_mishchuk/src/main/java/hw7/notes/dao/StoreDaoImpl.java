package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw7.notes.dao
 */
public class StoreDaoImpl implements StoreDao {

    private Logger log = Logger.getLogger(StoreDaoImpl.class);
    private SessionFactory factory;

    public StoreDaoImpl(){

    }

    public StoreDaoImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public  Long create(Store store){
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(store);
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
    public Store read(Long ig){
        Session session = factory.openSession();
        try {
            return (Store)session.get(Store.class, ig);
        } catch (HibernateException e){
            log.error("ERROR");
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Store store){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(store);
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
    public boolean delete(Store store){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(store);
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

    public List findAll(){
        Session session = factory.openSession();
        Query query = session.createQuery("from Store");
        return query.list();

    }
}