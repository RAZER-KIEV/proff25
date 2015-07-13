package hw7.springnotes.dao;

import hw7.springnotes.dao.SalesDao;
import hw7.springnotes.domain.Sales;
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
public class SalesDaoImpl implements SalesDao {

    @Autowired
    private SessionFactory factory;

    public SalesDaoImpl() {
    }

    public SalesDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Sales sales) {
        return (Long)factory.getCurrentSession().save(sales);
    }

    @Override
    public Sales read(Long ig) {
        return (Sales)factory.getCurrentSession().get(Sales.class, ig);
    }

    @Override
    public boolean update(Sales store) {
        boolean result;
        factory.getCurrentSession().update(store);
        result = true;
        return result;
    }

    @Override
    public boolean delete(Sales store) {
        boolean result;
        factory.getCurrentSession().delete(store);
        result = true;
        return result;
    }

    @Override
    public List<Sales> findAll() {
        return factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Sales").list();
    }
}
