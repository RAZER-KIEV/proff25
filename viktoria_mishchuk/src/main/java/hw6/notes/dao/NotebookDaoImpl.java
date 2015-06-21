package hw6.notes.dao;


import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.*;
import java.util.List;


/**
 * Created by viktoria
 * Project:.hw6.notes.dao
 */
public class NotebookDaoImpl implements NotebookDao{
    private static Logger log = Logger.getLogger(NotebookDao.class);
    private SessionFactory factory;

    public NotebookDaoImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb){
        Session session = factory.openSession();
        Long id;
        try {
            session.beginTransaction();
            id = (Long)session.save(ntb);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Notebook read(Long id){
        Session session = factory.openSession();
        try {
            return (Notebook)session.get(Notebook.class, id);
        } catch (HibernateException e){
            log.error("Transaction failed");
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public boolean update(Notebook ntb){
        Session session = factory.openSession();
        try {
            session.update(ntb.getId());
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        }finally {
            session.clear();
        }
        return true;
    }

    @Override
    public  boolean delete(Notebook ntb){
        Session session = factory.openSession();
        try {
            session.delete(ntb);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List<Notebook> findAll(){
        Session session = factory.openSession();
        Query query = session.createQuery("from NOTEBOOK");
        return query.list();
    }



}
