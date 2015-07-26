package hw7.notes.dao;

import hw7.notes.domain.CPU;
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
public class CPUDaoImpl implements CPUDao {

    private Logger log = Logger.getLogger(CPUDaoImpl.class);
    private SessionFactory factory;

    public CPUDaoImpl(){

    }

    public CPUDaoImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(CPU cpu){
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(cpu);
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
    public CPU read(Long ig){
        Session session = factory.openSession();
        try {
            return (CPU)session.get(CPU.class, ig);
        } catch (HibernateException e){
            log.error("ERROR");
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(CPU cpu){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().commit();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(CPU cpu){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(cpu);
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
        Query query = session.createQuery("from CPU");
        return query.list();
    }
}
