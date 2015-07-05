package hw7.notes.dao;

import hw7.notes.domain.CPU;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by jax on 05.07.15.
 */
public class CPUDaoImpl implements CPUDao{
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory sessionFactory;

    public CPUDaoImpl(){

    }

    public CPUDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @Override
    public Long create(CPU cpu) {
        Session session = sessionFactory.openSession();
        Long id =null;
        try{
            session.beginTransaction();
            id = (Long)session.save(cpu);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return id;
    }

    @Override
    public CPU read(Long id) {
        Session session = sessionFactory.openSession();
        try{
            return (CPU)session.get(CPU.class,id);
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Boolean update(CPU cpu) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public Boolean delete(CPU cpu) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        try{
            Query query = session.createQuery("from hw7.notes.domain.CPU");
            return query.list();
        }catch (HibernateException e){
            log.error("Error");
            return null;
        }
    }
}
