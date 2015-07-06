package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public class VendorDaoImpl implements VendorDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);
    private SessionFactory factory;

    public VendorDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public VendorDaoImpl(){

    }
    @Override
    public Long create(Vendor vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(vendor);
            session.getTransaction().commit();
            return id;
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
    public Vendor read(Long id) {
        Session session = null;
        try {
            session = factory.openSession();
            return (Vendor) session.get(Vendor.class, id);

        }catch (HibernateException e){
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return null;
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(vendor);
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
    public boolean delete(Vendor vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(vendor);
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
    public List<Vendor> findAll() {
        Session session = null;
        List<Vendor> vendors = new ArrayList<>();
        try {
            session = factory.openSession();
            vendors = session.createCriteria(Vendor.class).list();

        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return vendors;
    }
}
