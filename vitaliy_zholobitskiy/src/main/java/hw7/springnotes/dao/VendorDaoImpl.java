package hw7.springnotes.dao;

import hw7.springnotes.dao.*;
import hw7.springnotes.dao.VendorDao;
import hw7.springnotes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by just1ce on 29.06.2015.
 */
@Component
public class VendorDaoImpl implements VendorDao {

    @Autowired
    private SessionFactory factory;

    public VendorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public VendorDaoImpl() {
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(vendor);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            System.out.println(e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Vendor read(Long id) {
        Session session = factory.openSession();
        try{
            return (Vendor)session.get(Vendor.class, id);
        } catch (HibernateException e){
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
        } catch (HibernateException e){
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;

    }

    @Override
    public boolean delete(Vendor vendor) {

        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
        } catch (HibernateException e){
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Vendor");
        return query.list();
    }

}
