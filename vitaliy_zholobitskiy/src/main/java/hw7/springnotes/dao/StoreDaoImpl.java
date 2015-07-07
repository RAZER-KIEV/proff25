package hw7.springnotes.dao;

import hw7.springnotes.dao.StoreDao;
import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Store;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by just1ce on 29.06.2015.
 */
@Repository
public class StoreDaoImpl implements StoreDao{
    @Autowired
    private SessionFactory factory;

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public StoreDaoImpl() {
    }

    @Override
    public Long create(Store store) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(store);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            System.out.println(e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Store read(Long id) {

        Session session = factory.openSession();
        try{
            return (Store)session.get(Store.class, id);
        } catch (HibernateException e){
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Store store) {

        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
        } catch (HibernateException e){
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Store store) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
        } catch (HibernateException e){
            System.out.println(e);
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
        Query query = session.createQuery("from Store");
        return query.list();

    }
    @Override
    public List getNotesByPorces(int size) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select notebook from Store store, Notebook notebook where store.notebook=notebook");
            query.setFirstResult(0);
            query.setMaxResults(size);
            return query.list();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
}
