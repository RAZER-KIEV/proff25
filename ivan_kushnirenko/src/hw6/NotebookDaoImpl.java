package hw6;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by ivan on 17.06.15.
 */
public class NotebookDaoImpl implements NotebookDao{

    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    @Override
    public Long create(Notebook ntb) {
        if (factory==null){
            factory = new HibernateUtil().createSessionFactory();
            log.info("Reference to SessionFactory " + factory);
        }
        Session session = factory.openSession();
        Long id = null;
        try{
            session.beginTransaction();
            id = (Long)session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            log.error("TRANSACTION FAILED.");
            e.printStackTrace();
            session.getTransaction().rollback(); // Он здесь нужен?
            session.close();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        log.info(session);
        return id;
    }

    @Override
    public Notebook read(Long id) {
        if(factory==null){
            factory = new HibernateUtil().createSessionFactory();
            log.info("Reference to SessionFactory " + factory);
        }
        Session session = factory.openSession();
        try {
            return (Notebook)session.get(Notebook.class,id);
        } catch (HibernateException e){
            log.error("READ FAILED.",e);
            e.printStackTrace();
            session.close();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        if (factory==null){
            factory = new HibernateUtil().createSessionFactory();
            log.info("Reference to SessionFactory " + factory);
        }
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("UPDATE FAILED.",e);
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return false;
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public boolean delete(Notebook ntb) {
        if(factory==null){
            factory = new HibernateUtil().createSessionFactory();
            log.info("Reference to SessionFactory " + factory);
        }
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("DELETE FAILED.", e);
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return false;
        } finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Notebook> findAll() {
        if (factory==null){
            factory = new HibernateUtil().createSessionFactory();
            log.info("Reference to SessionFactory " + factory);
        }
        Session session = factory.openSession();
        Query query = session.createQuery("from hw6.Notebook");
        return query.list();
    }

    public static void main(String[] args) {
        Notebook nb1 = new Notebook();
        nb1.setSerial(8437632L);
        nb1.setModel("hp");
        nb1.setVendor("HP_Shop");
        nb1.setPrice(528);
        nb1.setManufactureDate(new Date(3915,3,21));
        NotebookDaoImpl nhdi = new NotebookDaoImpl();
        List<Notebook> notebooks = nhdi.findAll();
        System.out.println(notebooks);
        nhdi.factory.close();
    }
}
