package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Store;
import hw7.springnotes.domain.Vendor;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoreDaoImpl implements StoreDao {
    @Autowired
    private SessionFactory factory;

    public StoreDaoImpl() {
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
    public Long create(Store store)
    {
        return (Long)factory.getCurrentSession().save(store);
    }

    @Override
    public Store read(Long id)  {
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
    @Override
    public List findAll() {
        List<Store>list;
        list =factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Store").list();
        return list;
    }
    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        List<Notebook>list;
        Query query =factory.getCurrentSession().createQuery("select nBook from hw7.springnotes.domain.Store");
        query.setFirstResult(0);
        query.setMaxResults(size);
        list= query.list();
        return list;
    }
    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        List<Notebook>list;
        Query query =factory.getCurrentSession().createQuery("select nBook from hw7.springnotes.domain.Store s where s.count>:kol");
        query.setParameter("kol", amount);
        list= query.list();
        return list;
    }
    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        Long cpuId=cpuVendor.getId();
        List<Notebook>list;
        Query query =factory.getCurrentSession().createQuery("select n from hw7.springnotes.domain.Store s, Notebook n, CPU c, Vendor v where s.nBook=n and n.processor=c and c.vendor=v and v.id=:vendid");
        query.setParameter("vendid", cpuId);
        list= query.list();
        return list;
    }
    @Override
    public List<Notebook> getNotebooksFromStore() {
        List<Notebook>list;
        Query query =factory.getCurrentSession().createQuery("select nBook from hw7.springnotes.domain.Store");
        list= query.list();
        return list;
    }
    @Override
    public Map getNotebooksStorePresent() {
        List<Vendor>list;
        Query query =factory.getCurrentSession().createQuery("select v from hw7.springnotes.domain.Store s, Notebook n, Vendor v where s.nBook=n and n.vendor=v");
        list= query.list();
        Map venNote = new HashMap<>();
        for(Vendor v: list) {
            venNote.putIfAbsent(v, v.getNoteSet());
        }
        return venNote;
    }
}