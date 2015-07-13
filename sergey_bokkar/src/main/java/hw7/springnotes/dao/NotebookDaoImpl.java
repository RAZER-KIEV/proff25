package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Well on 03.07.2015.
 */
@Repository
public class NotebookDaoImpl implements NotebookDao {
    @Autowired
    private SessionFactory factory;

    public NotebookDaoImpl (){}

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        Long id;
        try {
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            System.out.println(exc);
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
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException exc) {
            System.out.println(exc);
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
        } catch (HibernateException exp) {
            System.out.println(exp);
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
        } catch (HibernateException exp) {
            System.out.println(exp);
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
        return session.createQuery("from Notebook n").list();
    }
}
