package hw6;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import java.util.Date;
import org.apache.log4j.Logger;

public class NotebookDaoImpl implements NotebookDao{

    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    private void checkFactory(){
        if (factory==null){
            factory = new HibernateUtil().createSessionFactory();
            log.info("Reference to SessionFactory " + factory);
        }
    }

    @Override
    public Long create(Notebook ntb) {
        checkFactory();
        Session session = factory.openSession();
        Long id = null;
        try{
            session.beginTransaction();
            id = (Long)session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            log.error("TRANSACTION FAILED.",e);
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
    public Notebook read(Long id) {
        checkFactory();
        Session session = factory.openSession();
        try {
            return (Notebook)session.get(Notebook.class,id);
        } catch (HibernateException e){
            log.error("READ FAILED.",e);
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
    public boolean update(Notebook ntb) {
        checkFactory();
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            log.info(session);
            return true;
        }catch (HibernateException e){
            log.error("UPDATE FAILED.",e);
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
    public boolean delete(Notebook ntb) {
        checkFactory();
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
        Query query = session.createQuery("from hw6.Notebook");
        return query.list();
    }

    public int deleteByModel(String model) {
        checkFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from hw6.Notebook n where n.model='"+model+"'");
            List<Notebook> notebooks = query.list();
            for (Notebook n : notebooks) {
                delete(n);
            }
            log.info(session);
            return notebooks.size();
        } catch (HibernateException e){
            log.error("OPERATION 'delete by model' FAILED.", e);
            e.printStackTrace();
            return -1;
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }

    public List<Notebook> readByVendor(String vendor) {
        checkFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from hw6.Notebook n where n.vendor='"+vendor+"'");
            return query.list();
        } catch (HibernateException e){
            log.error("ERORR: read by vendor failed.",e);
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        log.info(session);
        return null;
    }

    public List<Notebook> readByPriceAndDate(Integer price, Date date) {
        checkFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from hw6.Notebook n where n.price='"+
                    price+"' AND n.manufactureDate like '"+date+"'");
            return query.list();
        } catch (HibernateException e){
            log.error("ERORR: read by price and date failed.",e);
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        log.info(session);
        return null;
    }

    public static void main(String[] args) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl();
//        Notebook n = new Notebook();
//        n.setId(11L);

//        System.out.println(notebookDao.read("Asus"));
        System.out.println(notebookDao.readByPriceAndDate(620,new Date(115,2,12)));

//        System.out.println(notebookDao.delete(n));
//        notebookDao.factory.close();
    }
}
