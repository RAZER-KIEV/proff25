package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by GFalcon on 25.06.15.
 */
public class StoreDaoImpl implements StoreDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public StoreDaoImpl(){

    }

    public StoreDaoImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Store obj) {
        Long id = null;
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            id = (Long)session.save(obj);
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
    public Store read(Long ig) {
        Session session = factory.openSession();
        try {
            return (Store)session.get(Store.class, ig);
        } catch (HibernateException e){
            log.error("Read operation error: " + e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Store obj) {
        boolean res = false;
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            session.update(obj);
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
    public boolean delete(Store obj) {
        boolean res = false;
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            session.delete(obj);
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
    public List<Store> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Memory");
        session.close();
        return query.list();
    }
}
