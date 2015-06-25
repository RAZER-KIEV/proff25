package hw7.notes.dao;

import hw7.notes.domain.CPU;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class CPUDaoImpl implements CPUDao {
    private SessionFactory factory;

    public CPUDaoImpl() {
    }
    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU processor) {
        Session session=factory.openSession();
        Long id=null;
        try {
            session.beginTransaction();
            id = (Long) session.save(processor);
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
    public CPU read(Long id) {
        Session session = factory.openSession();
        try{
            return (CPU)session.get(CPU.class, id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }
    @Override
    public boolean update(CPU processor) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(processor);
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
    public boolean delete(CPU processor) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(processor);
            session.getTransaction().commit();}
        catch(HibernateException e){
            session.getTransaction().rollback();
            return false;}
        finally {
            if (session!=null)
                session.close();}
        return false;
    }
    @Override
    public List findAll() {
        Session session = factory.openSession();
        List<CPU>list;
        list =session.createQuery("from hw7.notes.domain.CPU").list();
        if (session!=null){
            session.close();}
        return list;
    }
}