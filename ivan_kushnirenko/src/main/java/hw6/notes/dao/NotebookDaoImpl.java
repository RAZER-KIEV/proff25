package hw6.notes.dao;


import hw6.notes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import java.util.Date;
import hw6.notes.util.HibernateUtil;

import org.apache.log4j.Logger;

public class NotebookDaoImpl implements NotebookDao {


    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    private void checkFactory(){
        if (factory==null){
            factory = new hw6.notes.util.HibernateUtil().createSessionFactory();
            log.info("Reference to SessionFactory " + factory);
        }
    }

    @Override
    public Long create(Notebook notebook) {
        checkFactory();
        Session session = factory.openSession();
        Long id = null;
        try{
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            log.error("ERROR: Cannot create new notebook - TRANSACTION FAILED.",e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        log.info(session);
        return id;
    }
    @Override
    public Notebook read(Long ig) {
        checkFactory();
        Session session = factory.openSession();
        try {
            return (Notebook)session.get(Notebook.class,ig);
        } catch (HibernateException e){
            log.error("ERROR: Cannot read notebook by id: "+ig+". READ FAILED.",e);
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        log.info(session);
        return null;
    }
    @Override
    public boolean update(Notebook notebook) {
        checkFactory();
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            log.info(session);
            return true;
        }catch (HibernateException e){
            log.error("ERROR: Cannot update notebook: "+notebook+". UPDATE FAILED.",e);
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }
    @Override
    public boolean delete(Notebook notebook) {
        checkFactory();
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("ERROR: Cannot delete notebook: "+notebook+". DELETE FAILED.", e);
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            if (session!=null){
                session.close();
            }
        }
    }
    @Override
    public List<Notebook> findAll() {
        checkFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from hw6.notes.domain.Notebook");
        return query.list();
    }
    @Override
    public List<Notebook> findByModel(String model) {
        checkFactory();
        Session session = factory.openSession();
        List<Notebook> notebooks = null;
        try {
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.model=:model");
            query.setParameter("model",model);
            notebooks = query.list();
        } catch (HibernateException e){
            log.error("ERROR: operation 'find by model' FAILED.", e);
            e.printStackTrace();
        } finally {
            if (session!=null){
                session.close();
            }
        }
        return notebooks;
    }
    @Override
    public List<Notebook> findByVendor(String vendor) {
        checkFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.vendor=:vendor");
            query.setParameter("vendor", vendor);/// Тут корячил, осторожно!
            return query.list();
        } catch (HibernateException e){
            log.error("ERORR: operation 'find by vendor' FAILED.",e);
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        log.info(session);
        return null;
    }
    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        checkFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.manufactureDate=:mDate and n.price=:price");
            query.setParameter("mDate",new java.util.Date(date.getTime()));
            query.setParameter("price", price);
            return query.list();
        } catch (HibernateException e){
            log.error("ERORR: operation 'find by price and date' FAILED.",e);
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        log.info(session);
        return null;
    }
    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor (Double priceFrom, Double priceTo, Date date, String vendor){
        checkFactory();
        Session session = factory.openSession();
        List<Notebook> result = null;
        try {
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.price>:minPrice and n.price<:maxPrice and n.vendor=:vendor and " +
                    "n.manufactureDate<:mDate"); // and n.manufactureDate<:mDate and n.price<:maxPrice " +
//            "and n.vendor=:vendor")
            query.setParameter("minPrice",priceFrom);
            query.setParameter("maxPrice",priceTo);
            query.setParameter("mDate",new java.util.Date(date.getTime()));
            query.setParameter("vendor",vendor);
            result=query.list();
        } catch (HibernateException e){
            log.error("ERROR: operation 'find by price range, manufacture date and vendor' FAILED.");
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
