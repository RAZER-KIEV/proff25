package hw7.springnotes.dao;


import hw7.springnotes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by oleg on 24.06.15.
 */
@Component
public class NotebookDaoImpl implements NotebookDao {
    @Autowired
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public NotebookDaoImpl() {
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long cr = (Long)session.save(notebook);
            session.getTransaction().commit();
            return cr;
        } catch (HibernateException exc) {
            System.out.println(exc);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Notebook read(Long ig) {

        Session session = factory.openSession();
        try{
            return (Notebook)session.get(Notebook.class, ig);
        } catch (HibernateException exc){
            System.out.println(exc);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
        } catch (HibernateException exc){
            System.out.println(exc);
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
        } catch (HibernateException exc){
            System.out.println(exc);
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook ");
        return query.list();
    }
}
