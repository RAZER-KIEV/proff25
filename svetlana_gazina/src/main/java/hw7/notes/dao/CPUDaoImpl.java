package hw7.notes.dao;

import hw6.notes.domain.Notebook;
import hw7.notes.domain.CPU;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Sveta on 6/26/2015.
 */
public class CPUDaoImpl implements CPUDao {
    private SessionFactory factory;

    public CPUDaoImpl() {

    }

    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU cpu) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(cpu);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return id;
    }

    @Override
    public CPU read(Long id) {
        Session session = factory.openSession();
        try {
            return (CPU) session.get(CPU.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return false;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from hw7.notes.dao");
        return query.list();
    }
}
