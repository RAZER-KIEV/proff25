package hw7.notes.dao;

import com.sun.xml.internal.ws.handler.HandlerException;
import hw7.notes.domain.Memory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw7.notes.dao
 */
public class MemoryDaoImpl implements MemoryDao {

    private Logger log = Logger.getLogger(MemoryDaoImpl.class);
    private SessionFactory factory;

    public MemoryDaoImpl(){

    }

    public MemoryDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory){
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(memory);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Memory read(Long ig){
        Session session = factory.openSession();
        try {
            return (Memory)session.get(Memory.class, ig);
        } catch (HibernateException e){
            log.error("ERROR");
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Memory memory){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(memory);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Memory memory){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(memory);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll(){
        Session session = factory.openSession();
        Query query = session.createQuery("from Memory");
        return query.list();
    }
}
