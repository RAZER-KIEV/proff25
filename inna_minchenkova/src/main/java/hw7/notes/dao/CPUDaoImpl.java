package hw7.notes.dao;

import hw7.notes.domain.CPU;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna on 28.06.2015.
 */
public class CPUDaoImpl implements CPUDao {
    private static Logger log = Logger.getLogger(CPUDaoImpl.class);
    private SessionFactory factory;

    public CPUDaoImpl(SessionFactory factory){
        this.factory = factory;

    }

    public CPUDaoImpl(){

    }
    @Override
    public Long create(CPU cpu) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(cpu);
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
    public CPU read(Long id) {
        Session session = null;
        try {
            session = factory.openSession();
            return (CPU) session.get(CPU.class, id);

        }catch (HibernateException e){
            log.error("Error opening session" + e);
        }finally {
            if(session != null)
                session.close();
        }
        return null;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(cpu);
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
    public boolean delete(CPU cpu) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(cpu);
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
    public List<CPU> findAll() {
        Session session = null;
        List<CPU> list = new ArrayList<>();
        try {
            session = factory.openSession();
            list = session.createCriteria(CPU.class).list();

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
