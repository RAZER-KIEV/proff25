package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;
import hw7.notes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

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
    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        Session session = factory.openSession();
        List<Notebook>list;
    Query query =session.createQuery("select nBook from hw7.notes.domain.Store");
        query.setFirstResult(0);
        query.setMaxResults(size);
        list= query.list();
        if (session!=null){
            session.close();}
        return list;
    }
    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        Session session = factory.openSession();
        List<Notebook>list;
        Query query =session.createQuery("select nBook from hw7.notes.domain.Store s where s.count>:kol");
        query.setParameter("kol", amount);
        list= query.list();
        if (session!=null){
            session.close();}
        return list;
    }
    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        Long cpuId=cpuVendor.getId();
        Session session = factory.openSession();
        List<Notebook>list;
        Query query =session.createQuery("select n from hw7.notes.domain.Store s, Notebook n, CPU c, Vendor v where s.nBook=n and n.processor=c and c.vendor=v and v.id=:vendid");
        query.setParameter("vendid", cpuId);
        list= query.list();
        if (session!=null){
            session.close();}
        return list;
    }
    @Override
    public List<Notebook> getNotebooksFromStore() {
        Session session = factory.openSession();
        List<Notebook>list;
        Query query =session.createQuery("select nBook from hw7.notes.domain.Store");
        list= query.list();
        return list;
    }
    @Override
    public Map getMapVendorNotesPresent() {
        Session session = factory.openSession();
        List<Vendor>list;
        Query query =session.createQuery("select v from hw7.notes.domain.Store s, Notebook n, Vendor v where s.nBook=n and n.vendor=v");
        list= query.list();
        Map venNote = new HashMap<>();
        for(Vendor v: list) {
            venNote.putIfAbsent(v, v.getNoteSet());
        }
        if (session!=null){
            session.close();}
        return venNote;
    }
    @Override
    public List getNotebooksStorePresent() {
        Session session = factory.openSession();
        List<Vendor>list;
        Query query =session.createQuery("select v from hw7.notes.domain.Store s, Notebook n, Vendor v where s.nBook=n and n.vendor=v");
        list= query.list();
        if (session!=null){
            session.close();}
        return list;
    }
}