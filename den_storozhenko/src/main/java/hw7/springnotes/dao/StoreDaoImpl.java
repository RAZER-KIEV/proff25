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

import java.util.*;
@Component
public class StoreDaoImpl implements StoreDao {
    private static final int STEP_PORCED =10;
    @Autowired
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
        return (Long)factory.getCurrentSession().save(store);
    }

    @Override
    public Store read(Long id) {
        return (Store)factory.getCurrentSession().get(Store.class, id);
    }

    @Override
    public boolean update(Store store) {
        factory.getCurrentSession().update(store);
        return true;
    }

    @Override
    public boolean delete(Store store) {
        factory.getCurrentSession().delete(store);
        return true;
    }

    public Long getCount(){
        return (Long)factory.getCurrentSession().createQuery("select COUNT(s.id) from Store s").uniqueResult();
    }

    @Override
    public List<Store> getStoresPorced(int start, int size) {
        Query query = factory.getCurrentSession().createQuery("from Store");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
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

    private List<Notebook> getNotesPorced(int start, int size){
        Query query = factory.getCurrentSession().createQuery("select n from Store s, Notebook n where s.notebook=n");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        List<Notebook> notebooks = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=size){
            notebooks.addAll(getNotesPorced(i, size));
        }
        return notebooks;
    }

    @Override
    public List getNotebooksFromStore() {
        return factory.getCurrentSession().createQuery("select n from Store s, Notebook n where s.notebook=n").list();
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        Query query = factory.getCurrentSession().createQuery("select n from Store s, Notebook n where s.notebook=n and s.count>:cnt");
        query.setParameter("cnt",amount);
        return query.list();
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        Query query = factory.getCurrentSession().createQuery("select n from Store s, Notebook n, Vendor v where s.notebook=n and n.vendor=v and v.name=:name");
        query.setParameter("name",cpuVendor.getName());
        return query.list();
    }

    @Override
    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        Query query = factory.getCurrentSession().createQuery("select n from Store s join s.notebook n");
        List results = query.list();
        Map<Vendor, List<Notebook>> resMap = new HashMap<>();
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            Notebook notebook = (Notebook)iter.next();
            Vendor key = notebook.getVendor();
            if (resMap.containsKey(key)){
                List<Notebook> notebooks = resMap.get(key);
                notebooks.add(notebook);
                resMap.replace(key,notebooks);
            }
            else{
                List<Notebook> notebooks = new ArrayList<>();
                notebooks.add(notebook);
                resMap.put(key,notebooks);
            }
        }
        return resMap;
    }
}
