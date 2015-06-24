package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session10.HiberConnect;

import java.util.Date;
import java.util.List;

/**
 * Created by Sveta on 6/18/2015.
 *  Создать DAO для таблицы ноутбуки
 Таблица ноутбуки имеет следующую структуру
 (id, serial, vendor, model, manufacture date, price)
 domain
 hw6.notes.domain.Notebook
 dao
 hw6.notes.dao.NotebookDao
 Long create(Notebook ntb)
 Notebook read(Long ig)
 boolean update(Notebook ntb)
 boolean delete(Notebook ntb)
 List<Notebook> findAll()
 hw6.notes.dao.NotebookDaoImpl
 *
 */
public class NotebookDaoImpl implements NotebookDao {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HiberConnect.class);
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
            log.error("Open session failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, id);

        } catch (HibernateException e) {
            log.error("Open session failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
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
            log.error("Open session failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
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
            log.error("Open session failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from hw6.notes.dao");
        return query.list();
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from hw6.notes.dao d" +
                " where d.model = model ");

        query.setParameter("model", model);
        return query.list();
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from hw6.notes.dao d" +
                " where d.vendor = vendor ");

        query.setParameter("vendor", vendor);
        return query.list();
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from hw6.notes.dao d" +
                " where d.price = price and d.date = date");

        query.setParameter("price", price);
        query.setParameter("date", date);
        return query.list();
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from hw6.notes.dao d" +
                " where d.price >= :priceFrom and d.price <= :priceTo and d.date = date and d.vendor = vendor");
        query.setParameter("priceFrom", priceFrom);
        query.setParameter("priceTo", priceTo);
        query.setParameter("date", date);
        query.setParameter("vendor", vendor);

        return query.list();
    }
}
