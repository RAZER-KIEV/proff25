package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

/**
 * Created by ПК on 25.06.2015.
 */
public class SalesDaoImpl implements SalesDao {
    private SessionFactory sessionFactory;

    public SalesDaoImpl(){}

    public SalesDaoImpl(SessionFactory sf) {
        sessionFactory = sf;
    }

    @Override
    public Long create(Sales store) {
        Session session = sessionFactory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(store);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not saved!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Sales read(Long id) {
        Session session = sessionFactory.openSession();
        Sales store = null;
        try {
            store = (Sales) session.get(Sales.class,id);
        }catch (HibernateException hEx){
            System.out.println("Exception: Not readed!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return store;
    }

    @Override
    public boolean update(Sales store) {
        Session session = sessionFactory.openSession();
        boolean upres = false;
        try {
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
            upres = true;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not saved!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return upres;
    }

    @Override
    public boolean delete(Sales store) {
        Session session = sessionFactory.openSession();
        boolean res;
        try {
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
            res = true;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not deleted!");
            hEx.printStackTrace();
            res = false;
        }finally {
            if (session !=null)
                session.close();
        }
        return res;
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Sales");
        return query.list();
    }

    @Override
    public Map getSalesByDays() {
        Session session = sessionFactory.openSession();
        List<Date> dateList = new ArrayList<>();
        Query query1 = null;
        Query query2 = null;
        int resCount=0;
        try {
            query1 = session.createQuery("select sale_date, avg(sales.quantity) from Sales group by sales.sale_date" +
                    "having sale_date");
            query2 = session.createQuery("select sale_date, avg(sales.quantity) from Sales group by sales.sale_date" +
                    "having avg(sales.quantity)");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        Map<Date,Integer> resMap = new HashMap<>();
        for (int i=0; query1.iterate().hasNext();i++){
            resMap.put((Date)query1.iterate().next(),(Integer)query2.iterate().next());

        }
        return resMap;
    }


}
