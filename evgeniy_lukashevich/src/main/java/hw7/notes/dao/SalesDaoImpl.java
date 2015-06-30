package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class SalesDaoImpl implements SalesDao {
    private SessionFactory factory;
    private static Logger logger = Logger.getLogger(SalesDaoImpl.class);

    public SalesDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SalesDaoImpl() {

    }

    @Override
    public Long create(Sales sales) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(sales);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Sales read(Long id) {
        Session session = factory.openSession();
        try {
            return (Sales) session.get(Sales.class, id);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Sales sales) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error("Transaction failed");
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
        try {
            Query query = session.createSQLQuery("SELECT * FROM sales").addEntity(Sales.class);
            return query.list();
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
