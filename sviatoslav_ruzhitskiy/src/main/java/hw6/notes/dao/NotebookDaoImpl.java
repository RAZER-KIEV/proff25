package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.Date;
import java.util.List;

/**
 * Created by ПК on 18.06.2015.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory(){return sessionFactory;}

    public NotebookDaoImpl(){}
    public NotebookDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = sessionFactory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(ntb);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException hEx){
            System.out.println("Exception: Not saved!");
            log.error("Exception: Not saved!  "+hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
      return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = sessionFactory.openSession();
        Notebook nbk = null;
        try {
            nbk = (Notebook) session.get(Notebook.class,id);
            //return nbk;
        }catch (HibernateException hEx){
            System.out.println("Exception: Not readed!");
            log.error("Exception: Not readed!  "+hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

        return nbk;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = sessionFactory.openSession();
        boolean upres = false;
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            upres = true;
        }catch (HibernateException hEx){
            System.out.println("Exception: Not saved!");
            log.error("Exception: Not saved!  "+hEx);
            //hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return upres;
    }

    @Override
    public boolean delete(Notebook ntb) {
           Session session = sessionFactory.openSession();
            boolean dlres = false;
            try {
                session.beginTransaction();
                session.delete(ntb);
                session.getTransaction().commit();
                dlres = true;
            }catch (HibernateException hEx){
                System.out.println("Exception: Not deleted!");
                log.error("Exception: Not deleted!  "+hEx);
                hEx.printStackTrace();
            }finally {
                if (session != null) {
                    session.close();
                }
            }
        return dlres;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook");
        query.setFirstResult(1);
        query.setMaxResults(2);
        return query.list();
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook n when n.model =: model");
        query.setParameter("model", model);
        query.setFirstResult(1);
        query.setMaxResults(2);
        return query.list();
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook n when n.vendor =: vendor");
        query.setParameter("model", vendor);
        query.setFirstResult(1);
        query.setMaxResults(2);
        return query.list();
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook n when n.manufacture_date =: date AND n.price = : price");
        query.setParameter("date", new java.sql.Date(date.getTime()));
        query.setParameter("price", price);
        query.setFirstResult(1);
        query.setMaxResults(2);
        return query.list();
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Notebook n when n.manufacture_date =: date AND n.price <= : priceTo AND n.price >= priceFrom AND n.vendor =: vendor");
        query.setParameter("date", new java.sql.Date(date.getTime()));
        query.setParameter("priceFrom", priceFrom);
        query.setParameter("priceTo", priceTo);
        query.setParameter("vendor", vendor);
        query.setFirstResult(1);
        query.setMaxResults(2);
        return query.list();
    }
}
