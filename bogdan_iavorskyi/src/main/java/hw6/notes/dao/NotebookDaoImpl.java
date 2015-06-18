package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

/*
 * Implementation of NotebookDao
 */
public class NotebookDaoImpl implements NotebookDao {

    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory) {
        log.info("Reference to SessionFactory " + factory);
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Long id = null;
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException exception) {
            log.error("Session Error on create(Notebook notebook)", exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = null;
        Notebook notebook = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            notebook = (Notebook) session.get(Notebook.class, id);
            session.getTransaction().commit();
        } catch (HibernateException exception) {
            log.error("Session Error on read(Long id)", exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return notebook;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = null;
        boolean isUpdateSuccessful = false;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            isUpdateSuccessful = true;
        } catch (HibernateException exception) {
            isUpdateSuccessful = false;
            log.error("Session Error on update(Notebook notebook)", exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return isUpdateSuccessful;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = null;
        boolean isDeleteSuccessful = false;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            isDeleteSuccessful = true;
        } catch (HibernateException exception) {
            isDeleteSuccessful = false;
            log.error("Session Error on update(Notebook notebook)", exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return isDeleteSuccessful;
    }

    @Override
    public List<Notebook> findAll() {
        List<Notebook> notebooks = null;
        Session session = null;
        try {
            session = factory.openSession();
            notebooks = session.createQuery("from Notebook").list();
        } catch (HibernateException exception) {
            log.error("Session open error", exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return notebooks;
    }

    @Override
    public List<Notebook> findChunk(int startPoint, int chunkSize) {
        List<Notebook> notebooks = null;
        Session session = null;
        try {
            session = factory.openSession();
            String strQuery = "from Notebook";
            Query query = session.createQuery(strQuery);
            query.setFirstResult(startPoint);
            query.setMaxResults(chunkSize);
            notebooks = query.list();
        } catch (HibernateException exception) {
            log.error("Session open error", exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return notebooks;
    }

    @Override
    public Long getCount() {
        Long count = null;
        Session session = null;
        try {
            session = factory.openSession();
            count = (Long) session.createQuery("select count(nt) from Notebook nt").uniqueResult();
        } catch (HibernateException exception) {
            log.error("Session open error", exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        return count;
    }
}
