package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;
import hw7.notes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by ПК on 25.06.2015.
 */

@Repository
public class StoreDaoImpl implements StoreDao{
    @Autowired
    private SessionFactory sessionFactory;

    public StoreDaoImpl(){}

    public StoreDaoImpl(SessionFactory sf) {
        sessionFactory = sf;
    }

    @Override
    public Long create(Store store) {
        Session session = sessionFactory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(store);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not saved!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Store read(Long id) {
        Session session = sessionFactory.openSession();
        Store store = null;
        try {
            store = (Store) session.get(Store.class,id);
        }catch (HibernateException hEx){
            System.out.println("Exception: Not readed!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return store;
    }

    @Override
    public boolean update(Store store) {
        Session session = sessionFactory.openSession();
        boolean upres = false;
        try {
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
            upres = true;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not saved!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return upres;

    }

    @Override
    public boolean delete(Store store) {
        Session session = sessionFactory.openSession();
        boolean res;
        try {
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
            res = true;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not deleted!");
            hEx.printStackTrace();
            res = false;
        }finally {
            if (session !=null)
                session.close();
        }
        return res;
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Store");
        return query.list();
    }

    @Override
    public List getNotebooksByPortion(int size) {
        Query query;
        List<Notebook> notebookList = new ArrayList<>();
        int start = 0;
        do {
            Session session = sessionFactory.openSession();

            try {
                query = session.createQuery("select Notebook n from Store s");
                query.setFirstResult(start);
                query.setMaxResults(size);
                notebookList.addAll(query.list());
            } finally {
                start += size;
                if (session != null) {
                    session.close();
                }
            }
        } while (query.list() != (null));
        return notebookList;
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        Session session = sessionFactory.openSession();
        List<Notebook> notebookList = new ArrayList<>();
        try{
            Query query = session.createQuery("select Notebook n from Store s where s.quantity>:amount");
            query.setParameter("amount",amount);
            notebookList = query.list();

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }

        return notebookList;
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        Session session = sessionFactory.openSession();
        List<Notebook> notebookList = new ArrayList<>();
        try{
            Query query = session.createQuery("select Notebook n from Store s where s.cpu.cpuVendor=:cpuVendor");
            query.setParameter("cpuVendor",cpuVendor);
            notebookList = query.list();

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }

        return notebookList;
    }

    @Override
    public List getNotebooksFromStore() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select notebook from Store");
        return query.list();



    }

    @Override
    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        Map<Vendor, List<Notebook>> resMap = new HashMap<>();
        Session session = sessionFactory.openSession();
        List<Vendor> vendorList = new ArrayList<>();
        try{
            Query query = session.createQuery("select s.notebook.vendor v from Store s where s.quantity>0 group by v");

            vendorList = query.list();

            for(Vendor vendor :vendorList){
                Query query1 = session.createQuery("select s.notebook n from Store s where s.quantity>0 and s.notebook.vendor=:vendor");
                query1.setParameter("vendor",vendor);
                List<Notebook> notebookList = query1.list();
                resMap.put(vendor,notebookList);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }

        return resMap;
    }



}
