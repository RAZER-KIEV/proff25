package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Sales;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by oleg on 25.06.15.
 */
public class SalesDaoImpl implements SalesDao {

    private SessionFactory factory;

    public SalesDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SalesDaoImpl() {
    }

    @Override
    public Long create(Sales store) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long cr = (Long)session.save(store);
            session.getTransaction().commit();
            return cr;
        } catch (HibernateException exc) {
            System.out.println(exc);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Sales read(Long ig) {

        Session session = factory.openSession();
        try{
            return (Sales)session.get(Sales.class, ig);
        } catch (HibernateException exc){
            System.out.println(exc);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Sales store) {

        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
        } catch (HibernateException exc){
            System.out.println(exc);
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Sales store) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
        } catch (HibernateException exc){
            System.out.println(exc);
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;

    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Sales");
        return query.list();
    }

    @Override
    public Map getSalesByDays() {
        Session session = factory.openSession();
        Map<Date, Double> map = new TreeMap<>();
        Query query = session.createQuery("select c.date, avg (c.amount) from Sales c join c.store p group by c.date");
        List list = query.list();
        for(int i = 0; i < list.size(); i++) {
            Object[] obj = (Object[]) list.get(i);
            map.put((Date)obj[0], (Double)obj[1]);
        }
        return map;
    }
}
