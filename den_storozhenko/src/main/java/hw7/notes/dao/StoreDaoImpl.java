package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class StoreDaoImpl implements StoreDao {
    private static final int STEP_PORCED =10;
    private SessionFactory factory;

    public StoreDaoImpl(){

    }

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public Long create(Store store) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(store);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
                session.close();
        }
        return id;
    }

    @Override
    public Store read(Long id) {
        Session session = factory.openSession();
        try{
            return (Store)session.get(Store.class,id);
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
        try {
            session.beginTransaction();
            session.delete(store);
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

    public Long getCount(){
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("select COUNT(s.id) from Store s");
            return (Long)query.uniqueResult();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Store> getStoresPorced(int start, int size) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Store");
            query.setFirstResult(start);
            query.setMaxResults(size);
            return query.list();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Store> findAll() {
        List<Store> stores = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            stores.addAll(getStoresPorced(i, STEP_PORCED));
        }
        return stores;
    }

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select n from Store s, Notebook n where s.notebook=n");
            query.setMaxResults(size);
            query.setFirstResult(0);
            return query.list();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List getNotebooksFromStore() {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select n from Store s, Notebook n where s.notebook=n");
            return query.list();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select n from Store s, Notebook n where s.notebook=n and s.count>:cnt");
            query.setParameter("cnt",amount);
            return query.list();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
}
