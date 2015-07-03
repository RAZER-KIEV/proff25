package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class SalesDaoImpl implements SalesDao {
    private static final int STEP_PORCED =10;
    @Autowired
    private SessionFactory factory;

    public SalesDaoImpl(){

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
    public Long create(Sales sales) {
        return (Long)factory.getCurrentSession().save(sales);
    }

    @Override
    public Sales read(Long id) {
        return (Sales)factory.getCurrentSession().get(Sales.class, id);
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

    public Long getCount(){
        return (Long)factory.getCurrentSession().createQuery("select COUNT(s.id) from Sales s").uniqueResult();
    }

    @Override
    public List<Sales> getSalesPorced(int start, int size) {
        Query query = factory.getCurrentSession().createQuery("from Sales");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<Sales> findAll() {
        List<Sales> sales = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            sales.addAll(getSalesPorced(i, STEP_PORCED));
        }
        return sales;
    }

    @Override
    public Map<Date, Double> getSalesByDays() {
        Query query = factory.getCurrentSession().createQuery("select s.date, AVG(s.count) from Sales s group by s.date");
        List results = query.list();
        Map<Date, Double> resMap = new HashMap<>();
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            Object object[] = (Object[]) iter.next();
            resMap.put((Date)object[0],(Double)object[1]);
        }
        return resMap;
    }
}
