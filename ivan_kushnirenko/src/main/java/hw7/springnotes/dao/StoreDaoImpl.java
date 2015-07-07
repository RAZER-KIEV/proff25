package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Store;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 */
@Repository
public class StoreDaoImpl implements StoreDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Store store) {
        return (Long) factory.getCurrentSession().save(store);
    }

    @Override
    public Store read(Long id) {
        return (Store) factory.getCurrentSession().get(Store.class, id);
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
    public List<Store> findAll() {
        Query query = factory.getCurrentSession().createQuery("from Store");
        return query.list();
    }

    public List<Store> getPorcedStore(int start, int portion) {
        if (start < 0 || portion <= 0 || portion <= start) {
            throw new IllegalArgumentException("ERROR: Input parameters 'start' and 'portion' must be correct.");
        }
        Query query = factory.getCurrentSession().createQuery("from Store");
        query.setFirstResult(start);
        query.setMaxResults(portion);
        return query.list();
    }

    public List<Notebook> getNotebooksFromStore() {
        Query query = factory.getCurrentSession().createQuery("select n from Store s, Notebook n where s.notebook=n");
        return query.list();
    }

    public List<Notebook> getNotebooksGtAmount(int amount) {
        Query query = factory.getCurrentSession().createQuery("select n from Store s, Notebook n where s.notebook=n and s.count>:amount");
        return query.list();
    }

    public static void main(String[] args) {

    }
}
