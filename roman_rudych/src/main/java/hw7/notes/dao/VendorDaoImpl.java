package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Роман on 26.06.2015.
 */
public class VendorDaoImpl implements VendorDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);
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
        try{
            session.beginTransaction();
            id = (Long)session.save(vendor);
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
    public Vendor read(Long ig) {
        Session session = factory.openSession();
        Vendor vendor= null;
        vendor = (Vendor)session.get(Vendor.class, ig);
        session.close();
        log.info(session);
        return vendor;
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.update(vendor);
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
    public boolean delete(Vendor vendor) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.delete(vendor);
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
    public List<Vendor> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.Vendor");
        return query.list();
    }
}
