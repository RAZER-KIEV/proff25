package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import hw7.springnotes.domain.Store;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by oleg on 25.06.15.
 */
@Repository
public class SalesDaoImpl implements SalesDao {
    @Autowired
    private SessionFactory factory;

    public SalesDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SalesDaoImpl() {
    }

    @Override
    public Long create(Sales store) {
        return (Long)factory.getCurrentSession().save(store);
    }

    @Override
    public Sales read(Long ig) {
        return (Sales)factory.getCurrentSession().get(Store.class, ig);
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
        Query query = factory.getCurrentSession().createQuery("from Sales");
        return query.list();
    }

    @Override
    public Map getSalesByDays() {
        Map<Date, Double> map = new TreeMap<>();
        Query query = factory.getCurrentSession().createQuery("select c.date, avg (c.amount) from Sales c join c.store p group by c.date");
        List list = query.list();
        for(int i = 0; i < list.size(); i++) {
            Object[] obj = (Object[]) list.get(i);
            map.put((Date)obj[0], (Double)obj[1]);
        }
        return map;
    }
}
