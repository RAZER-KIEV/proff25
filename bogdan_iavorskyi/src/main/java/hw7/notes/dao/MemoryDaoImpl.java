package hw7.notes.dao;

import hw7.notes.domain.Memory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MemoryDaoImpl implements MemoryDao {
//    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    private SessionFactory factory;

    public MemoryDaoImpl() {

    }

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(memory);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Memory read(Long id) {
        Session session = null;
        Memory memory = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            memory = (Memory) session.get(Memory.class, id);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return memory;
    }

    @Override
    public boolean update(Memory memory) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(memory);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(Memory memory) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(memory);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll() {
        Session session = null;
        List resultingList = null;
        try {
            session = factory.openSession();
            resultingList = session.createQuery("from Memory as c").list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return resultingList;
    }
}
