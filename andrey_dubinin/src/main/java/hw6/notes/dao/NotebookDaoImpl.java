package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.sql.Date;
import java.util.List;

/**
 * Created by jax on 21.06.15.
 */
public class NotebookDaoImpl implements NotebookDao{
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory){
        this.factory = factory;
    }
    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        Long id =null;
        try{
            session.beginTransaction();
            id = (Long)session.save(ntb);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try{
            return (Notebook)session.get(Notebook.class,id);
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("from hw6.notes.domain.Notebook");
            return query.list();
        }catch (HibernateException e){
            log.error("Error");

        }
        return null;
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.model='"+model+"'");
            return query.list();
        }catch (HibernateException e){
            log.error("Error");
        }
        return null;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.vendor='"+vendor+"'");
            return query.list();
        }catch (HibernateException e){
            log.error("Error");
        }

        return null;
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.price=price and n.manufacture_date=date");
            return query.list();
        }catch (HibernateException e){
            log.error("Error");
        }
        return null;
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.price>=:priceFrom and n.price<=:priceTo and n.manufacture_date=date and n.vendor=vendor ");
            query.setParameter("manufacture_date",date);
            query.setParameter("vendor",vendor);
            query.setParameter("priceFrom",priceFrom);
            query.setParameter("priceTo",priceTo);
            return query.list();
        }catch (HibernateException e){
            log.error("Error");
        }
        return null;
    }
}
