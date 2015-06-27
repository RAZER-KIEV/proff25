package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 27.06.15.
 */

public class SalesDaoImpl implements SalesDao {
    private static final int STEP_PORCED =10;
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
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(sales);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
                session.close();
        }
        return id;
    }

    @Override
    public Sales read(Long id) {
        Session session = factory.openSession();
        try{
            return (Sales)session.get(Sales.class,id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean update(Sales sales) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(sales);
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
    public boolean delete(Sales sales) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(sales);
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

    public Long getCount(){
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select COUNT(s.id) from Sales s");
            return (Long) query.uniqueResult();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Sales> getSalesPorced(int start, int size) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Sales");
            query.setFirstResult(start);
            query.setMaxResults(size);
            return query.list();
        }finally {
            if (session!=null){
                session.close();
            }
        }
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
}
