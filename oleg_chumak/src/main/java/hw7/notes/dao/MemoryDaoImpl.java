package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by oleg on 25.06.15.
 */
public class MemoryDaoImpl implements MemoryDao {

    private SessionFactory factory;

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public MemoryDaoImpl() {
    }

    @Override
    public Long create(Memory memory) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long cr = (Long)session.save(memory);
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
    public Memory read(Long ig) {

        Session session = factory.openSession();
        try{
            return (Memory)session.get(Memory.class, ig);
        } catch (HibernateException exc){
            System.out.println(exc);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Memory memory) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(memory);
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
        Query query = session.createQuery("from Memory");
        return query.list();
    }
}
