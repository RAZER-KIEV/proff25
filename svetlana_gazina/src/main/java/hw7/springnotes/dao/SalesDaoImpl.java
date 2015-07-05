package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
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
public class SalesDaoImpl implements SalesDao{
    @Autowired(required = true)
    private SessionFactory factory;

    public SalesDaoImpl() {
    }

    public SalesDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {

        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Sales store) {
        return (Long) factory.getCurrentSession().save(store);
    }

    @Override
    public Sales read(Long ig) {
        return (Sales) factory.getCurrentSession().get(Sales.class, ig);
    }

    @Override
    public boolean update(Sales store) {
        factory.getCurrentSession().update(store);
        return true;
    }

    @Override
    public boolean delete(Sales store) {
        factory.getCurrentSession().delete(store);
        return true;
    }

    @Override
    public List findAll() {
        Query query = factory.getCurrentSession().createQuery("from Sales ");
        return query.list();
    }
}
