package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by oleg on 17.06.15.
 */
public class NotebookDaoImpl implements NotebookDao {

    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public NotebookDaoImpl() {
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException except){
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Notebook read(Long ig) {
        Session session = factory.openSession();
        Notebook note = (Notebook) session.get(Notebook.class, ig);
        return note;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return  true;
        } catch (HibernateException exc){
            session.getTransaction().rollback();
            return  false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException except){
            session.getTransaction().rollback();
            return  false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook");
        return query.list();
    }
}
