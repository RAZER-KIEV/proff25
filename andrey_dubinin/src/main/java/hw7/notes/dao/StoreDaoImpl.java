package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by jax on 05.07.15.
 */
public class StoreDaoImpl implements StoreDao{
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory sessionFactory;

    public StoreDaoImpl(){

    }

    public StoreDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }


    @Override
    public Long create(Store store) {
        Session session = sessionFactory.openSession();
        Long id =null;
        try{
            session.beginTransaction();
            id = (Long)session.save(store);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return id;
    }

    @Override
    public Store read(Long id) {
        Session session = sessionFactory.openSession();
        try{
            return (Store)session.get(Store.class,id);
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Boolean update(Store store) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public Boolean delete(Store store) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        try{
            Query query = session.createQuery("from hw7.notes.domain.Store");
            return query.list();
        }catch (HibernateException e){
            log.error("Error");
            return null;
        }
    }
}
