package classwork.dao;

import taxi.domain.Taxist;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Well on 14.07.2015.
 */
public class TaxistDaoImpl implements TaxistDao {
    private SessionFactory factory;

    public TaxistDaoImpl(){}

    public TaxistDaoImpl(SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public Long create(Taxist tax) {
        Session session = factory.openSession();
        Long id;
        try {
            session.beginTransaction();
            id = (Long)session.save(tax);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Taxist read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            return (Taxist) session.get(Taxist.class, id);
        } catch (HibernateException e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Taxist tax) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(tax);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Taxist tax) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(tax);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Taxist> findAll() {
        Session session = factory.openSession();
        return session.createQuery("from Taxist t").list();
    }
}
