package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StoreDaoImpl implements StoreDao {
//    private static Logger log = Logger.getLogger(StoreDaoImpl.class);
    private SessionFactory factory;

    public StoreDaoImpl() {

    }

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Store lot) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(lot);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Store read(Long id) {
        Session session = null;
        Store lot = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            lot = (Store) session.get(Store.class, id);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return lot;
    }

    @Override
    public boolean update(Store lot) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(lot);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Store lot) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(lot);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll() {
        Session session = null;
        List resultingList = null;
        try {
            session = factory.openSession();
            resultingList = session.createQuery("from Store as c").list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return resultingList;
    }
}
