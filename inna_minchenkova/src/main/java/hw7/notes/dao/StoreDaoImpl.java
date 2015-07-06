package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public class StoreDaoImpl implements StoreDao {
    private static Logger log = Logger.getLogger(StoreDaoImpl.class);
    private SessionFactory factory;

    public StoreDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public StoreDaoImpl(){

    }
    @Override
    public Long create(Store store) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(store);

            session.getTransaction().commit();
            return store.getId();
        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return null;
}

    @Override
    public Store read(Long id) {
        Session session = null;
        try {
            session = factory.openSession();
            return (Store) session.get(Store.class, id);

        }catch (HibernateException e){
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return null;
    }

    @Override
    public boolean update(Store store) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session !=  null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Store store) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public List<Store> findAll() {
        Session session = null;
        List<Store> list = new ArrayList<>();
        try {
            session = factory.openSession();
            list = session.createCriteria(Store.class).list();

        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return list;
    }
}
