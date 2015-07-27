package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw7.notes.dao
 */
public class VendorDaoImp implements VendorDao{

    private Logger log = Logger.getLogger(VendorDaoImp.class);
    private SessionFactory factory;

    public VendorDaoImp(){

    }

    public VendorDaoImp(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Vendor vendor){
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(vendor);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Vendor read(Long ig){
        Session session = factory.openSession();
        try {
            return (Vendor)session.get(Vendor.class,ig);
        } catch (HibernateException e){
            log.error("ERROR");
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Vendor vendor){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Vendor vendor){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll(){
        Session session = factory.openSession();
        Query query = session.createQuery("from Vendor");
        return query.list();
    }
}
