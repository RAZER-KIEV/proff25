package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
@Repository
public class SalesDaoImpl implements SalesDao {
    @Autowired
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
    public Long create(Sales sales) {
        return (Long)factory.getCurrentSession().save(sales);
    }
    @Override
    public Sales read(Long id) {
        return (Sales)factory.getCurrentSession().get(Sales.class, id);
    }
    @Override
    public boolean update(Sales sales) {
        factory.getCurrentSession().delete(sales);
        return true;
    }
    @Override
    public boolean delete(Sales sales) {
        factory.getCurrentSession().update(sales);
        return true;
    }
    @Override
    public List findAll() {
        List<Sales>list;
        list =factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Sales").list();
        return list;
    }
    //Получить объем продаж ноутбуков в среднем за день (в штуках)*/
    @Override
    public Map getSalesByDays() {
        Map map = new TreeMap<>();
        List<Object>list;
        //Query query =factory.getCurrentSession().createQuery("select s.saleDate, avg(s.count) from Sales s group by s.saleDate");
        Query query =factory.getCurrentSession().createQuery("select s.saleDate, sum(c.price*s.count) from Sales s, Store c where s.stor=c group by s.saleDate");
        list=query.list();
        for(int i=0; i<list.size(); i++){
        Object [] objV=(Object [])list.get(i);
        map.put(objV[0], objV[1]);
}
        return map;
    }
}