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
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by oleg on 25.06.15.
 */
@Repository
public class StoreDaoImpl implements hw7.springnotes.dao.StoreDao {

    private SessionFactory factory;

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public StoreDaoImpl() {
    }

    @Override
    public Long create(Store store) {
        return (Long)factory.getCurrentSession().save(store);
    }

    @Override
    public Store read(Long ig) {
        return (Store)factory.getCurrentSession().get(Store.class, ig);
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
        Query query = factory.getCurrentSession().createQuery("from Store");
        return query.list();

    }

    @Override
    public List<Notebook> getNotesPorced(int start, int size) {
        Query query = factory.getCurrentSession().createQuery("select n from Store s, Notebook n where s.noteBook=n");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List getNotebooksFromStore() {
            Query query = factory.getCurrentSession().createQuery("select n from Store s, Notebook n where s.noteBook=n");
            return query.list();
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
            Query query = factory.getCurrentSession().createQuery("select n from Store s, Notebook n where s.noteBook=n and s.amount>:cnt");
            query.setParameter("cnt",amount);
            return query.list();
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
            Query query = factory.getCurrentSession().createQuery("select n from Store s, Notebook n, Vendor v where s.noteBook=n and n.vendor=v and v.name=:name");
            query.setParameter("name",cpuVendor.getName());
            return query.list();
    }


    @Override
    public Map<Vendor, List<Notebook>> getNotebooksStorePresent() {
        Query query = factory.getCurrentSession().createQuery("select s.noteBook.vendor, s.noteBook from Store s join s.noteBook n join s.noteBook.vendor");
        List res = query.list();
        Map<Vendor, List<Notebook>> map = new HashMap<>();
        List<Notebook> notes = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            Object[] obj = (Object[]) res.get(i);
            if (map.containsKey(obj[0])) {
                notes = map.get(obj[0]);
                notes.add((Notebook) obj[1]);
                map.put((Vendor) obj[0], notes);
            } else {
                notes.clear();
                notes.add((Notebook) obj[1]);
                map.put((Vendor) obj[0], notes);
            }
        }
        return map;
    }
}
