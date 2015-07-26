package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw7.notes.dao
 */
public class SalesDaoImpl implements SalesDao{

    private Logger log = Logger.getLogger(SalesDaoImpl.class);
    private SessionFactory factory;

    public SalesDaoImpl(){

    }

    public SalesDaoImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public  Long create(Sales store){
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(store);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
        return  id;
    }

    @Override
    public Sales read(Long ig){
        Session session = factory.openSession();
        try {
            return (Sales)session.get(Sales.class, ig);
        } catch (HibernateException e){
            log.error("ERROR");
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Sales store){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Sales store){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public List findAll(){
        Session session = factory.openSession();
        Query query = session.createQuery("from Sales");
        return query.list();

    }
}
