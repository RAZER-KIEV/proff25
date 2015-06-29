package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;
import hw7.notes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session11.Firm.Person;

import java.util.*;

/**
 * Created by oleg on 25.06.15.
 */
public class StoreDaoImpl implements StoreDao{

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
        try {
            Query query = session.createQuery("select v from Store s, Notebook n, Vendor v where s.noteBook=n and n.vendor=v");
            List res = query.list();
            Set<Vendor> setVendor = new HashSet<>();
            for (Iterator iter = res.iterator(); iter.hasNext();) {
                setVendor.add((Vendor) iter.next());
            }
            Map<Vendor,List<Notebook>> longListMap = new HashMap<>();
            for (Vendor vendor:setVendor){
                Query query1 = session.createQuery("select n from Store s join s.noteBook n join n.vendor v where v.id=:id");
                query1.setParameter("id", vendor.getId());
                longListMap.put(vendor,query1.list());
            }
            return longListMap;
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
}
