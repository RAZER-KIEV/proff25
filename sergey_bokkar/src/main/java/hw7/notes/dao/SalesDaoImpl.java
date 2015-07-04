package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Well on 03.07.2015.
 */
public class SalesDaoImpl implements SalesDao {
    private SessionFactory factory;

    public SalesDaoImpl (){}

    public SalesDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Sales store) {
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
    public Sales read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            return (Sales) session.get(Sales.class, id);
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
    public boolean update(Sales store) {
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
    public boolean delete(Sales store) {
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
        return session.createQuery("from Sales s").list();
    }
}
