package hw7.springnotes.dao;

import hw7.notes.dao.*;
import hw7.notes.dao.CPUDao;
import hw7.notes.domain.CPU;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by just1ce on 29.06.2015.
 */
public class CPUDaoImpl implements hw7.springnotes.dao.CPUDao {

    private SessionFactory factory;
    public CPUDaoImpl() {
    }

    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(hw7.springnotes.domain.CPU cpu) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(cpu);
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
    public hw7.springnotes.domain.CPU read(Long id) {
        Session session = factory.openSession();
        try{
            return (hw7.springnotes.domain.CPU)session.get(hw7.springnotes.domain.CPU.class, id);
        } catch (HibernateException e){
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(hw7.springnotes.domain.CPU cpu) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(cpu);
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
    public boolean delete(hw7.springnotes.domain.CPU cpu) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(cpu);
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
        Query query = session.createQuery("from CPU ");
        return query.list();
    }


}
