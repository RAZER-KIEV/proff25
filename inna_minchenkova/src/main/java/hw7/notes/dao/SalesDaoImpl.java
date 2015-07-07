package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public class SalesDaoImpl implements SalesDao {
    private static Logger log = Logger.getLogger(SalesDaoImpl.class);
    private SessionFactory factory;

    public SalesDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public SalesDaoImpl(){

    }
    @Override
    public Long create(Sales sales) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(sales);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return null;
    }

    @Override
    public Sales read(Long id) {
        Session session = null;
        try {
            session = factory.openSession();
            return (Sales) session.get(Sales.class, id);

        }catch (HibernateException e){
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return null;
    }

    @Override
    public boolean update(Sales sales) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session !=  null)
                session.close();
        }

        return false;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public List<Sales> findAll() {
        Session session = null;
        List<Sales> list = new ArrayList<>();
        try {
            session = factory.openSession();
            list = session.createCriteria(Sales.class).list();

        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return list;
    }
}
