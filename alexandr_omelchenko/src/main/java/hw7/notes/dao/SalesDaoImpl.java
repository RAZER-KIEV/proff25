package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SalesDaoImpl implements SalesDao {
    private SessionFactory factory;

    public SalesDaoImpl() {
    }
    public SalesDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public Long create(Sales store) {
        Session session=factory.openSession();
        Long id=null;
        try {
            session.beginTransaction();
            id = (Long) session.save(store);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return id;
    }
    @Override
    public Sales read(Long id) {
        Session session = factory.openSession();
        try{
            return (Sales)session.get(Sales.class, id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }
    @Override
    public boolean update(Sales store) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }
    @Override
    public boolean delete(Sales store) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
        return false;
    }
    @Override
    public List findAll() {
        Session session = factory.openSession();
        List<Sales>list;
        list =session.createQuery("from hw7.notes.domain.Sales").list();
        if (session!=null){
            session.close();}
        return list;
    }
    //Получить объем продаж ноутбуков в среднем за день (в штуках)*/
    @Override
    public Map getSalesByDays() {
        Map map = new TreeMap<>();
        Session session = factory.openSession();
        List<Object>list;
        Query query =session.createQuery("select s.saleDate, avg(s.count) from Sales s group by s.saleDate");
        //Query query =session.createQuery("select s.saleDate, sum(c.price*s.count)/count(s.saleDate) from Sales s, Store c where s.stor=c group by s.saleDate");
        list=query.list();
        for(int i=0; i<list.size(); i++){
        Object [] objV=(Object [])list.get(i);
        map.put(objV[0], objV[1]);
}
        if (session!=null){
            session.close();}
        return map;
    }
}