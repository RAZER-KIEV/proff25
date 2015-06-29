package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by GFalcon on 25.06.15.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(){

    }

    public NotebookDaoImpl (SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public Long create(Notebook notebook) {
        Long id = null;
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Create transaction error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long ig) {
        Session session = factory.openSession();
        try {
            return (Notebook)session.get(Notebook.class, ig);
        } catch (HibernateException e){
            log.error("Read operation error: " + e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Notebook notebook) {
        boolean res = false;
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            session.update(notebook);
            session.getTransaction().commit();
            res = true;
        } catch (HibernateException e){
            log.error("Update error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return res;
    }

    @Override
    public boolean delete(Notebook notebook) {
        boolean res = false;
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            session.delete(notebook);
            session.getTransaction().commit();
            res = true;
        } catch (HibernateException e){
            log.error("Delete operation error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return res;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook");
        List<Notebook> notebookList = query.list();
        session.close();
        return notebookList;
    }
}
