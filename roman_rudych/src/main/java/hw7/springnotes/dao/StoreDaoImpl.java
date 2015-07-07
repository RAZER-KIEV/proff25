package hw7.springnotes.dao;

import hw7.springnotes.dao.*;
import hw7.springnotes.dao.StoreDao;
import hw7.springnotes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Роман on 26.06.2015.
 */
@Repository
public class StoreDaoImpl implements StoreDao {

    @Autowired
    private SessionFactory factory;

    public StoreDaoImpl() {
    }

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
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
        boolean result;
        factory.getCurrentSession().update(store);
        result = true;
        return result;
    }

    @Override
    public boolean delete(Store store) {
        boolean result;
        factory.getCurrentSession().delete(store);
        result = true;
        return result;
    }

    @Override
    public List<Store> findAll() {
        return factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Store").list();
    }
}
