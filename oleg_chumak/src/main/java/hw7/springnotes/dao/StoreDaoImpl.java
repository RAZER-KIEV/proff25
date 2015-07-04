package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Store;
import hw7.springnotes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by oleg on 25.06.15.
 */
@Component
public class StoreDaoImpl implements hw7.springnotes.dao.StoreDao {
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
            Long cr = (Long)session.save(store);
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
    public Store read(Long ig) {

        Session session = factory.openSession();
        try{
            return (Store)session.get(Store.class, ig);
        } catch (HibernateException exc){
            System.out.println(exc);
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
    public boolean delete(Store store) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(store);
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
        Query query = session.createQuery("from Store");
        return query.list();

    }

    @Override
    public List<Notebook> getNotesPorced(int start, int size) {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("select n from Store s, Notebook n where s.noteBook=n");
            query.setFirstResult(start);
            query.setMaxResults(size);
            return  query.list();
        } catch (HibernateException exc){
            System.out.println(exc);
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public List getNotebooksFromStore() {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select n from Store s, Notebook n where s.noteBook=n");
            return query.list();
        }catch (HibernateException exc){
            System.out.println(exc);
            session.getTransaction().rollback();
            return null;
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
            Query query = session.createQuery("select n from Store s, Notebook n where s.noteBook=n and s.amount>:cnt");
            query.setParameter("cnt",amount);
            return query.list();
        }catch (HibernateException exc){
            System.out.println(exc);
            session.getTransaction().rollback();
            return null;
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select n from Store s, Notebook n, Vendor v where s.noteBook=n and n.vendor=v and v.name=:name");
            query.setParameter("name",cpuVendor.getName());
            return query.list();
        }catch (HibernateException exc){
            System.out.println(exc);
            session.getTransaction().rollback();
            return null;
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }


    @Override
    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        Session session = factory.openSession();
        Map<Vendor,List<Notebook>> longListMap = new HashMap<>();
        try {
            Query query = session.createQuery("select s.noteBook.vendor, s.noteBook from Store s join s.noteBook n join s.noteBook.vendor");
            List res = query.list();
            Map<Vendor, List<Notebook>> map = new HashMap<>();
            List<Notebook> notes = new ArrayList<>();
            for(int i = 0; i < res.size(); i++) {
                Object[] obj = (Object[]) res.get(i);
                if (map.containsKey((Vendor)obj[0])){
                    notes = map.get((Vendor)obj[0]);
                    notes.add((Notebook)obj[1]);
                    map.put((Vendor)obj[0], notes);
                } else {
                    notes.clear();
                    notes.add((Notebook)obj[1]);
                    map.put((Vendor)obj[0], notes);
                }
            }
            System.out.println(map);
            return map;
        } catch ( HibernateException exc) {
            System.out.println(exc);
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
        return  longListMap;
    }
}
