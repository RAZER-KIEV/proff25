package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class StoreDaoImpl implements StoreDao {
    private SessionFactory factory;
    private static Logger logger = Logger.getLogger(StoreDaoImpl.class);

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public StoreDaoImpl() {

    }

    @Override
    public Long create(Store store) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(store);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Store read(Long id) {
        Session session = factory.openSession();
        try {
            return (Store) session.get(Store.class, id);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Store store) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Store store) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        try {
            Query query = session.createSQLQuery("SELECT * FROM store").addEntity(Store.class);
            return query.list();
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
