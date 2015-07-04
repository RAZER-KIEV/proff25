package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ПК on 25.06.2015.
 */

@Repository
@Transactional
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
        Query query1 = null;
        Query query2 = null;
        try {
            query1 = session.createQuery("select s.sale_date from Sales s group by s.sale_date order by s.sale_date");
            query2 = session.createQuery("select s.sale_date, avg(sales.quantity) from Sales s group by s.sale_date order by s.sale_date" +
                    "having avg(s.quantity)");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        Map<Date,Double> resMap = new HashMap<>();
        for (int i=0; query1.iterate().hasNext();i++){
            resMap.put((Date)query1.iterate().next(),(Double)query2.iterate().next());
        }
        return resMap;
    }
}
