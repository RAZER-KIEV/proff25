package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna on 19.06.2015.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory){
        this.factory = factory;

    }

    public NotebookDaoImpl() {

    }

    @Override
    public Long create(Notebook notebook) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(notebook);
            session.getTransaction().commit();
            return id;

        }catch (HibernateException e){
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        }finally {
            if(session != null)
                session.close();

        }
        return null;
    }

    @Override
    public Notebook read(Long id) {
        Session session = null;
        try{
            session = factory.openSession();
            return (Notebook)session.get(Notebook.class, id);

        }catch (HibernateException e){
            log.error("Open session failed", e);

        }finally {
            if(session != null)
                session.close();
        }
        return null;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Open session failed", e);
            session.getTransaction().commit();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = null;
        List<Notebook> notebooks = new ArrayList<>();
        try {
            session = factory.openSession();
            notebooks = session.createCriteria(Notebook.class).list();

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            if(session != null)
                session.close();
        }
        return notebooks;
    }
}
