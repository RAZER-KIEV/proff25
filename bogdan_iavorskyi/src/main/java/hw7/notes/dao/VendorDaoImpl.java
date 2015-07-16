package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by bosyi on 25.06.15.
 */
public class VendorDaoImpl implements VendorDao {
//    private static Logger log = Logger.getLogger(VendorDaoImpl.class);
    private SessionFactory factory;

    public VendorDaoImpl() {

    }

    public VendorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(vendor);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Vendor read(Long id) {
        Session session = null;
        Vendor vendor = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            vendor = (Vendor) session.get(Vendor.class, id);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return vendor;
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(vendor);
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
    public boolean delete(Vendor vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(vendor);
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
            resultingList = session.createQuery("from Vendor as v").list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return resultingList;
    }

    @Override
    public List findAllNames() {
        Session session = null;
        List resultingList = null;
        try {
            session = factory.openSession();
            resultingList = session.createQuery("select v.name from Vendor as v").list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return resultingList;
    }
}
