package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class NotebookDaoImpl implements NotebookDao {
//    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl() {

    }

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
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
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return notebook;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll() {
        Session session = null;
        List resultingList = null;
        try {
            session = factory.openSession();
            resultingList = session.createQuery("from Notebook as c").list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return resultingList;
    }
}
