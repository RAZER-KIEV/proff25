package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Sveta on 6/26/2015.
 */
public class VendorDaoImpl implements VendorDao {
    private SessionFactory factory;

    public VendorDaoImpl() {
    }

    public VendorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(vendor);
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
    public Vendor read(Long id) {
        Session session = factory.openSession();
        try {
            return (Vendor) session.get(Vendor.class, id);

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
    public boolean update(Vendor vendor) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(vendor);
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
    public boolean delete(Vendor vendor) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(vendor);
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
