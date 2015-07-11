package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Well on 03.07.2015.
 */
@Repository
public class CPUDaoImpl implements CPUDao {
    @Autowired
    private SessionFactory factory;

    public CPUDaoImpl (){}

    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU cpu) {
        Session session = factory.openSession();
        Long id;
        try {
            session.beginTransaction();
            id = (Long)session.save(cpu);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            System.out.println(exc);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
           return null;
    }

    @Override
    public CPU read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            return (CPU) session.get(CPU.class, id);
        } catch (HibernateException exc) {
            System.out.println(exc);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exp) {
            System.out.println(exp);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exp) {
            System.out.println(exp);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        return session.createQuery("from CPU c").list();
    }
}
