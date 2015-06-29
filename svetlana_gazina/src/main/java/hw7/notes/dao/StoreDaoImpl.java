package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Sveta on 6/26/2015.
 */
public class StoreDaoImpl implements StoreDao {
    private SessionFactory factory;

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
            id = (Long)session.save(store);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return id;
    }

    @Override
    public Store read(Long id){
        Session session = factory.openSession();
        try {
            return (Store) session.get(Store.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
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
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
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
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return false;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from hw7.notes.dao");
        return query.list();
    }
}
