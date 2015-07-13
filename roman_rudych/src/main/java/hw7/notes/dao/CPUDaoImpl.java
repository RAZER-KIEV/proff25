package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Роман on 26.06.2015.
 */
public class CPUDaoImpl implements CPUDao {
    private Logger log = Logger.getLogger(CPUDaoImpl.class);
    private SessionFactory factory;

    public CPUDaoImpl() {}

    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU cpu) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(cpu);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            log.error("Saving error", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return id;
    }

    @Override
    public CPU read(Long ig) {
        Session session = factory.openSession();
        CPU cpu = null;
        cpu = (CPU)session.get(CPU.class, ig);
        session.close();
        log.info(session);
        return cpu;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException ex) {
            log.error("Updating error", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return result;
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            result = true;
        } catch (HibernateException ex) {
            log.error("Deleting fail", ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        log.info(session);
        return result;
    }

    @Override
    public List<CPU> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.CPU");
        return query.list();
    }
}
