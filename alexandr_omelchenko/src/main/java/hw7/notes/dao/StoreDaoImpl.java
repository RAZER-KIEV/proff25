package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by HP on 25.06.2015.
 */
public class StoreDaoImpl implements StoreDao {
    private SessionFactory factory;

    public StoreDaoImpl() {
    }
    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public Long create(Store store) {
        Session session=factory.openSession();
        Long id=null;
        try {
            session.beginTransaction();
            id = (Long) session.save(store);
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
    public Store read(Long id) {
        Session session = factory.openSession();
        try{
            return (Store)session.get(Store.class, id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }
    @Override
    public boolean update(Store store) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(store);
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
    public boolean delete(Store store) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(store);
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
        List<Store>list;
        list =session.createQuery("from hw7.notes.domain.Store").list();
        if (session!=null){
            session.close();}
        return list;
    }
}