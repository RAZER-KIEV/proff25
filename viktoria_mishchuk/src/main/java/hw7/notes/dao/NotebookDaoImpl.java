package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw7.notes.dao
 */
public class NotebookDaoImpl implements NotebookDao{

    private Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(){

    }

    public NotebookDaoImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public  Long create(Notebook notebook){
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
        return  id;
    }

    @Override
    public Notebook read(Long ig){
        Session session = factory.openSession();
        try {
            return (Notebook)session.get(Notebook.class, ig);
        } catch (HibernateException e){
            log.error("ERROR");
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Notebook notebook){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Notebook notebook){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public List findAll(){
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook");
        return query.list();

    }
}
