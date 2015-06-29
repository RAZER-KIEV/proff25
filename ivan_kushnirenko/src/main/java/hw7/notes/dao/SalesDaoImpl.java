package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 */
public class SalesDaoImpl implements SalesDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    private void checkFactory() {
        if (factory == null) {
            Configuration cfg = new Configuration()
                    .addAnnotatedClass(hw7.notes.domain.Notebook.class)
                    .addAnnotatedClass(hw7.notes.domain.Vendor.class)
                    .addAnnotatedClass(hw7.notes.domain.CPU.class)
                    .addAnnotatedClass(hw7.notes.domain.Memory.class)
                    .addAnnotatedClass(hw7.notes.domain.Store.class)
                    .addAnnotatedClass(hw7.notes.domain.Sales.class)
                    .configure("hw7/hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            factory = cfg.buildSessionFactory(standardServiceRegistry);
        }
    }

    @Override
    public Long create(Sales sales) {
        checkFactory();
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(sales);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("ERROR: Cannot create new sales - TRANSACTION FAILED.", e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return id;
    }

    @Override
    public Sales read(Long ig) {
        checkFactory();
        Session session = factory.openSession();
        try {
            return (Sales) session.get(Sales.class, ig);
        } catch (HibernateException e) {
            log.error("ERROR: Cannot read sales by id: " + ig + ". READ FAILED.", e);
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return null;
    }

    @Override
    public boolean update(Sales sales) {
        checkFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            log.info(session);
            return true;
        } catch (HibernateException e) {
            log.error("ERROR: Cannot update sales: " + sales + ". UPDATE FAILED.", e);
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(Sales sales) {
        checkFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("ERROR: Cannot delete sales: " + sales + ". DELETE FAILED.", e);
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Sales> findAll() {
        checkFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.Sales");
        return query.list();
    }

    public static void main(String[] args) {

    }
}
