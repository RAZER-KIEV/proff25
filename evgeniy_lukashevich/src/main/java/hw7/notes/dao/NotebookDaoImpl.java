package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Jeckgehor on 29.06.2015.
 */

public class NotebookDaoImpl implements NotebookDao {
    private SessionFactory factory;
    private static Logger logger = Logger.getLogger(NotebookDaoImpl.class);

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    NotebookDaoImpl() {

    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(notebook);
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
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, id);
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
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(notebook);
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
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(notebook);
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
            Query query = session.createSQLQuery("SELECT * FROM notebook").addEntity(Notebook.class);
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