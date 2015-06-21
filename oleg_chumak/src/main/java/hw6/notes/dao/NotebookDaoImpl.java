package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by oleg on 17.06.15.
 */
public class NotebookDaoImpl implements NotebookDao {

    private SessionFactory factory;

    private HibernateUtil util = new HibernateUtil();

    public SessionFactory getFactory() {
        return factory;
    }

    public NotebookDaoImpl() {
        util.createSessionFactory();
        this.factory = util.getFactory();
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String dateS = sdf.format(ntb.getDate().getTime());
            Long id = (Long)session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException except){
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Notebook read(Long ig) {
        Session session = factory.openSession();
        Notebook note = (Notebook) session.get(Notebook.class, ig);
        return note;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return  true;
        } catch (HibernateException exc){
            session.getTransaction().rollback();
            return  false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException except){
            session.getTransaction().rollback();
            return  false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook");
        return query.list();
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook c where c.model = '"+model+"'");
        return query.list();
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook c where c.vendor = '"+vendor+"'");
        return query.list();
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook n where n.date=:m_date and n.price=:price");
        query.setParameter("m_date",new java.sql.Date(date.getTime()));
        query.setParameter("price",price);
        return query.list();
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {

        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook n where n.date=:m_date and n.vendor=:vendor and n.price>=:priceFrom and n.price<=:priceTo");
        query.setParameter("m_date", date);
        query.setParameter("vendor", vendor);
        query.setParameter("priceFrom", priceFrom);
        query.setParameter("priceTo", priceTo);
        return query.list();
    }
}
