package hw7.notes.dao;

import hw7.notes.domain.Memory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Well on 03.07.2015.
 */
public class MemoryDaoImpl implements MemoryDao {
    private SessionFactory factory;

    public MemoryDaoImpl (){}

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) {
        Session session = factory.openSession();
        Long id;
        try {
            session.beginTransaction();
            id = (Long)session.save(memory);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            System.out.println(exc);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Memory read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            return (Memory) session.get(Memory.class, id);
        } catch (HibernateException exc) {
            System.out.println(exc);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Memory memory) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(memory);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exp) {
            System.out.println(exp);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Memory memory) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(memory);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exp) {
            System.out.println(exp);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        return session.createQuery("from Memory m").list();
    }
}
