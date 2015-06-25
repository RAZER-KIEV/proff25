package hw7.notes.dao;

import hw7.notes.domain.Memory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class MemoryDaoImpl implements MemoryDao {
    private SessionFactory factory;

    public MemoryDaoImpl() {
    }
    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) {
        Session session=factory.openSession();
        Long id=null;
        try {
            session.beginTransaction();
            id = (Long) session.save(memory);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return id;
    }
    @Override
    public Memory read(Long id) {
        Session session = factory.openSession();
        try{
            return (Memory)session.get(Memory.class, id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }
    @Override
    public boolean update(Memory memory) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(memory);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }
    @Override
    public boolean delete(Memory memory) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(memory);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
        return false;
    }
    @Override
    public List findAll() {
        Session session = factory.openSession();
        List<Memory>list;
        list =session.createQuery("from hw7.notes.domain.Memory").list();
        if (session!=null){
            session.close();}
        return list;
    }
}
