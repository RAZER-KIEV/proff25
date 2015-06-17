package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private static final int STEP_PORCED =2;
    private SessionFactory factory;

    public NotebookDaoImpl(){

    }

    public SessionFactory getFactory() {
        return factory;

    }

    public void setFactory(SessionFactory factory) {

        this.factory = factory;
    }

    public NotebookDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(ntb);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
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
        }finally {
            if (session!=null)
                session.close();
        }
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    private Long getCount(){
        Session session = factory.openSession();
        Query query = session.createQuery("select COUNT(n.id) from Notebook n");
        return (Long)query.uniqueResult();
    }

    @Override
    public List<Notebook> getNotebooksPorced(int start, int size) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List findAll() {
        List<Notebook> notebooks = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            notebooks.addAll(getNotebooksPorced(i,STEP_PORCED));
        }
        return notebooks;
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook n where n.model=:model");
        query.setParameter("model",model);
        List<Notebook> notebooks = query.list();
        if(session!=null)
            session.close();
        return notebooks;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook n where n.vendor=:vendor");
        query.setParameter("vendor",vendor);
        List<Notebook> notebooks = query.list();
        if(session!=null)
            session.close();
        return notebooks;
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook n where n.manufacture_date=:m_date and n.price=:price");
        query.setParameter("m_date",date);
        query.setParameter("price",price);
        List<Notebook> notebooks = query.list();
        if(session!=null)
            session.close();
        return notebooks;
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook n where n.manufacture_date<:m_date and n.price>:priceFrom and " +
                "n.price<:priceTo and n.vendor=:vendor");
        query.setParameter("m_date",date);
        query.setParameter("priceFrom",priceFrom);
        query.setParameter("priceTo",priceTo);
        query.setParameter("vendor",vendor);
        List<Notebook> notebooks = query.list();
        if(session!=null)
            session.close();
        return notebooks;
    }
}
