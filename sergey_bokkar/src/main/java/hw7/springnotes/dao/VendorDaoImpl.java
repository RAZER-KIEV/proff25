package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Well on 03.07.2015.
 */
@Repository
public class VendorDaoImpl implements VendorDao {
    @Autowired
    private SessionFactory factory;

    public VendorDaoImpl (){}

    public VendorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = factory.openSession();
        Long id;
        try {
            session.beginTransaction();
            id = (Long)session.save(vendor);
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
    public Vendor read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            return (Vendor) session.get(Vendor.class, id);
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
    public boolean update(Vendor vendor) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(vendor);
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
    public boolean delete(Vendor vendor) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(vendor);
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
        return session.createQuery("from Vendor v").list();
    }
}
