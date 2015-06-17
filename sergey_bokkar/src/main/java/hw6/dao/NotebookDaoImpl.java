package hw6.dao;

import hw6.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Well on 17.06.2015.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

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
}
