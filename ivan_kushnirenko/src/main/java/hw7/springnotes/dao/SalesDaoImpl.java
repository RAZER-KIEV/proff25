package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by ivan on 24.06.15.
 */
@Repository
public class SalesDaoImpl implements SalesDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Sales sales) {
        return (Long) factory.getCurrentSession().save(sales);
    }

    @Override
    public Sales read(Long id) {
        return (Sales) factory.getCurrentSession().get(Sales.class, id);
    }

    @Override
    public boolean update(Sales sales) {
        factory.getCurrentSession().update(sales);
        return true;
    }

    @Override
    public boolean delete(Sales sales) {
        factory.getCurrentSession().delete(sales);
        return true;
    }

    @Override
    public List<Sales> findAll() {
        Query query = factory.getCurrentSession().createQuery("from Sales");
        return query.list();
    }

    public List<Sales> getPorcedSales(int start, int portion) {
        if (start < 0 || portion <= 0 || portion <= start) {
            throw new IllegalArgumentException("ERROR: Input parameters 'start' and 'portion' must be correct.");
        }
        Query query = factory.getCurrentSession().createQuery("from Sales");
        query.setFirstResult(start);
        query.setMaxResults(portion);
        return query.list();
    }

    public Map<Date, Double> getSalesByDays() {
        Query query = factory.getCurrentSession().createQuery("select s.date, AVG(s.count) from Sales s group by s.date");
        List results = query.list();
        Map<Date, Double> resMap = new HashMap<>();
        for (Iterator iter = results.iterator(); iter.hasNext(); ) {
            Object object[] = (Object[]) iter.next();
            resMap.put((Date) object[0], (Double) object[1]);
        }
        return resMap;
    }

    public static void main(String[] args) {

    }
}
