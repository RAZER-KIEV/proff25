package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Well on 03.07.2015.
 */
public class StoreDaoImpl implements StoreDao {
    private SessionFactory factory;

    public StoreDaoImpl (){}

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Store store) {
        Session session = factory.openSession();
        Long id;
        try {
            session.beginTransaction();
            id = (Long)session.save(store);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            System.out.println(exc);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Store read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            return (Store) session.get(Store.class, id);
        } catch (HibernateException exc) {
            System.out.println(exc);
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
        } catch (HibernateException exp) {
            System.out.println(exp);
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
        } catch (HibernateException exp) {
            System.out.println(exp);
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
        return session.createQuery("from Store s").list();
    }
}
