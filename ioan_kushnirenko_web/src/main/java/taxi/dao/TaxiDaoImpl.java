package taxi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taxi.domain.Taxi;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Well on 14.07.2015.
 */
@Repository
public class TaxiDaoImpl implements TaxiDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(Taxi tax) {
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
    public Taxi read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            return (Taxi) session.get(Taxi.class, id);
        } catch (HibernateException e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Taxi tax) {
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
    public boolean delete(Taxi tax) {
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
    public List<Taxi> findAll() {
        Session session = factory.openSession();
        return session.createQuery("from taxi.domain.Taxi").list();
    }
}
