package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by Well on 17.06.2015.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(){
        HibernateUtil hu = new HibernateUtil();
        this.factory = hu.connect();
    }

    public NotebookDaoImpl(SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        Long id;
        try {
            session.beginTransaction();
            id = (Long)session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return null;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        return session.createQuery("from Notebook t").list();
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook n where n.model=:model");
        query.setParameter("model",model);
        return query.list();
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook n where n.vendor=:vendor");
        query.setParameter("vendor",vendor);
        if (session != null)
            session.close();
        log.info(session);
        return query.list();
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook n where n.price=:price and n.manufacture_date=:date");
        query.setParameter("price", price);
        query.setParameter("date",date);
        if (session != null)
            session.close();
        log.info(session);
        return query.list();
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook n where n.manufacture_date<:date and n.price>:priceFrom and " +
                "n.price<:priceTo and n.vendor=:vendor");
        query.setParameter("vendor",vendor);
        query.setParameter("priceTo", priceTo);
        query.setParameter("priceFrom", priceFrom);
        query.setParameter("date",date);
        if (session != null)
            session.close();
        log.info(session);
        return query.list();
    }
}
