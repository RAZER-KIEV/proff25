package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by jax on 05.07.15.
 */
public class VendorDaoImpl implements VendorDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory sessionFactory;

    public VendorDaoImpl(){

    }
    public VendorDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = sessionFactory.openSession();
        Long id =null;
        try{
            session.beginTransaction();
            id = (Long)session.save(vendor);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return id;
    }

    @Override
    public Vendor read(Long id) {
        Session session = sessionFactory.openSession();
        try{
            return (Vendor)session.get(Vendor.class,id);
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        try{
            Query query = session.createQuery("from hw7.notes.domain.Vendor");
            return query.list();
        }catch (HibernateException e){
            log.error("Error");
            return null;
        }
    }
}
