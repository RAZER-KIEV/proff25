package hw7.notes.dao;

import hw7.notes.domain.CPU;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CPUDaoImpl implements CPUDao {
//    private static Logger log = Logger.getLogger(CPUDaoImpl.class);
    private SessionFactory factory;

    public CPUDaoImpl() {

    }

    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU cpu) {
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(cpu);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public CPU read(Long id) {
        Session session = null;
        CPU cpu = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            cpu = (CPU) session.get(CPU.class, id);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return cpu;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List findAll() {
        Session session = null;
        List resultingList = null;
        try {
            session = factory.openSession();
            resultingList = session.createQuery("from CPU as c").list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return resultingList;
    }
}
