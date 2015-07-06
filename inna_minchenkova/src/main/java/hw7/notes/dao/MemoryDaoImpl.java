package hw7.notes.dao;

import hw7.notes.domain.Memory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public class MemoryDaoImpl implements MemoryDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    private SessionFactory factory;

    public MemoryDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public MemoryDaoImpl(){

    }
    @Override
    public Long create(Memory memory) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(memory);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return null;
    }

    @Override
    public Memory read(Long id) {
        Session session = null;
        try {
            session = factory.openSession();
            return (Memory) session.get(Memory.class, id);

        }catch (HibernateException e){
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return null;
    }

    @Override
    public boolean update(Memory memory) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(memory);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session !=  null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Memory memory) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(memory);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public List<Memory> findAll() {
        Session session = null;
        List<Memory> list = new ArrayList<>();
        try {
            session = factory.openSession();
            list = session.createCriteria(Memory.class).list();

        }catch (HibernateException e){
            session.getTransaction().rollback();
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return list;
    }
}
