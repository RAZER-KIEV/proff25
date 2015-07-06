package hw7.springnotes.dao;

import hw7.springnotes.dao.*;
import hw7.springnotes.dao.StoreDao;
import hw7.springnotes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Роман on 26.06.2015.
 */
@Repository
public class StoreDaoImpl implements StoreDao {

    @Autowired
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(hw7.notes.dao.StoreDaoImpl.class);

    public StoreDaoImpl() {
    }

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Store store) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(store);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            log.error("Saving error", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return id;
    }

    @Override
    public Store read(Long ig) {
        Session session = factory.openSession();
        Store store = null;
        store = (Store)session.get(Store.class, ig);
        session.close();
        log.info(session);
        return store;
    }

    @Override
    public boolean update(Store store) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException ex) {
            log.error("Updating error", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return result;
    }

    @Override
    public boolean delete(Store store) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException ex) {
            log.error("Deleting fail", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return result;
    }

    @Override
    public List<Store> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.springnotes.domain.Store");
        return query.list();
    }
}
