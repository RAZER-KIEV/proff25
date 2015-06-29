package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

/**
 * Создать DAO для таблицы ноутбуки
 * Таблица ноутбуки имеет следующую структуру
 * (id, serial, vendor, model, manufacture date, price)
 * domain
 * hw6.notes.domain.Notebook
 * dao
 * hw6.notes.dao.NotebookDao
 * Long create(Notebook ntb)
 * Notebook read(Long ig)
 * boolean update(Notebook ntb)
 * boolean delete(Notebook ntb)
 * List<Notebook> findAll()
 * hw6.notes.dao.NotebookDaoImpl
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl() {

    }

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Notebook read(Long id) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = null;
        try {
            session = factory.openSession();
            Criteria criteria = session.createCriteria(Notebook.class);
            return criteria.list();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = null;
        try {
            session = factory.openSession();
            Criteria criteria = session.createCriteria(Notebook.class, model);
            return criteria.list();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            Criteria criteria = session.createCriteria(Notebook.class, vendor);
            return criteria.list();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = null;
        try {
            session = factory.openSession();
            Criteria criteria = session.createCriteria(Notebook.class).add(Restrictions.eq("price", price))
                    .add(Restrictions.eq("manufacture_date", date));
            return criteria.list();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = null;
        try {
            session = factory.openSession();
            Criteria criteria = session.createCriteria(Notebook.class)
                    .add(Restrictions.between("price", priceFrom, priceTo))
                    .add(Restrictions.le("date", date))
                    .add(Restrictions.eq("vendor", vendor));
            return criteria.list();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
