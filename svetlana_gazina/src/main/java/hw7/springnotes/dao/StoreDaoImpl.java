package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sveta on 7/5/2015.
 */
@Repository
@Transactional
public class StoreDaoImpl implements StoreDao {
    @Autowired(required = true)
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
    public Long create(Store store) {
        return (Long) factory.getCurrentSession().save(store);
    }

    @Override
    public Store read(Long ig) {
        return (Store) factory.getCurrentSession().get(Store.class, ig);
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
        Query query = factory.getCurrentSession().createQuery("from Store ");
        return query.list();
    }
}
