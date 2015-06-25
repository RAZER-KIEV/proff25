package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class NotebookDaoImpl implements NotebookDao {
    private SessionFactory factory;

    public NotebookDaoImpl() {
    }
    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session=factory.openSession();
        Long id=null;
        try {
            session.beginTransaction();
            id = (Long) session.save(notebook);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try{
            return (Notebook)session.get(Notebook.class, id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }
    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }
    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
        return false;
    }
    @Override
    public List findAll() {
        Session session = factory.openSession();
        List<Notebook>list;
        list =session.createQuery("from hw7.notes.domain.Notebook").list();
        if (session!=null){
            session.close();}
        return list;
    }
}
