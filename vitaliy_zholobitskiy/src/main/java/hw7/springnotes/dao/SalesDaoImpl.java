package hw7.springnotes.dao;

import hw7.notes.dao.*;
import hw7.springnotes.dao.SalesDao;
import hw7.springnotes.domain.Sales;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by just1ce on 29.06.2015.
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
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(store);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            System.out.println(e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Sales read(Long id) {

        Session session = factory.openSession();
        try{
            return (Sales)session.get(Sales.class, id);
        } catch (HibernateException e){
            System.out.println(e);
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
        } catch (HibernateException e){
            System.out.println(e);
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
        } catch (HibernateException e){
            System.out.println(e);
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
}
