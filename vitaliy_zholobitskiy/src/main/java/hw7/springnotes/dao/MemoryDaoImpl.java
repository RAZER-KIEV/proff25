package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by just1ce on 29.06.2015.
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
            Long id = (Long)session.save(memory);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            System.out.println(e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Memory read(Long id) {

        Session session = factory.openSession();
        try{
            return (Memory)session.get(Memory.class, id);
        } catch (HibernateException e){
            System.out.println(e);
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
        } catch (HibernateException e){
            System.out.println(e);
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
        } catch (HibernateException e){
            System.out.println(e);
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
