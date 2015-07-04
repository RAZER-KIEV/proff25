package hw7.springnotes.dao;

import hw7.springnotes.dao.CPUDao;
import hw7.springnotes.domain.CPU;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by oleg on 25.06.15.
 */
@Component
public class CPUDaoImpl implements CPUDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(CPU cpu) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long cr = (Long)session.save(cpu);
            session.getTransaction().commit();
            return cr;
        } catch (HibernateException exc) {
            System.out.println(exc);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public CPU read(Long ig) {
        Session session = factory.openSession();
        try{
            return (CPU)session.get(CPU.class, ig);
        } catch (HibernateException exc){
            System.out.println(exc);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
        } catch (HibernateException exc){
            System.out.println(exc);
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
        } catch (HibernateException exc){
            System.out.println(exc);
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from CPU ");
        return query.list();
    }

    public CPUDaoImpl() {
    }

    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }
}
