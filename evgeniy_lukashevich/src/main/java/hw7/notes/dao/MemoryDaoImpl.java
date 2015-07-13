package hw7.notes.dao;

import hw7.notes.domain.Memory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class MemoryDaoImpl implements MemoryDao {
    private SessionFactory factory;
    private static Logger logger = Logger.getLogger(MemoryDaoImpl.class);

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public MemoryDaoImpl () {

    }

    @Override
    public Long create(Memory memory) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(memory);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Memory read(Long id) {
        Session session = factory.openSession();
        try {
            return (Memory) session.get(Memory.class, id);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
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
        } catch (HibernateException e) {
            logger.error("Transaction failed");
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
        } catch (HibernateException e) {
            logger.error("Transaction failed");
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
        try {
            Query query = session.createSQLQuery("SELECT * FROM memory").addEntity(Memory.class);
            return query.list();
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
