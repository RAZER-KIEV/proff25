package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Роман on 25.06.2015.
 */
public class NotebookDaoImpl implements NotebookDao {
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            log.error("Saving error", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        Notebook notebook = null;
        notebook = (Notebook)session.get(Notebook.class, id);
        session.close();
        log.info(session);
        return notebook;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException ex) {
            log.error("Updating error", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return result;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException ex) {
            log.error("Deleting fail", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return result;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook");
        return query.list();
    }
}
