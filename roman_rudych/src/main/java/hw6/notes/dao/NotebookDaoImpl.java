package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by Роман on 18.06.2015.
 */
public class NotebookDaoImpl implements NotebookDao {

    private static Logger log = Logger.getLogger(NotebookDao.class);
    private SessionFactory factory;

    public NotebookDaoImpl() {
    }

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(ntb);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        return (Notebook)session.get(Notebook.class, id);
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            e.printStackTrace();
            session.getTransaction().rollback();
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            e.printStackTrace();
            session.getTransaction().rollback();
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        return session.createQuery("from hw6.notes.domain.Notebook").list();
    }

    @Override
    public List findByModel(String model) {
        Session session = factory.openSession();
        return session.createQuery("from hw6.notes.domain.Notebook n where n.model = '"+model+"'").list();
    }

    @Override
    public List findByVendor(String vendor) {
        Session session = factory.openSession();
        return session.createQuery("from hw6.notes.domain.Notebook n where n.vendor = '"+vendor+"' ").list();
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.price = :price and n.manufactureDate = :date ");
        query.setParameter("price", price);
        query.setParameter("date", date);
        return query.list();
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.price >= :priceFrom " +
                "and n.price < :priceTo and n.manufactureDate < :date and n.vendor = :vendor ");
        query.setParameter("priceFrom", priceFrom);
        query.setParameter("priceTo", priceTo);
        query.setParameter("date", date);
        query.setParameter("vendor", vendor);
        return query.list();
    }

    public List<Notebook> findAll(int fromId, int toId) {
        Session session = factory.openSession();
        return session.createQuery("from hw6.notes.domain.Notebook n where n.id >= '"+fromId+"' and n.id < '"+toId+"'").list();
    }
}
