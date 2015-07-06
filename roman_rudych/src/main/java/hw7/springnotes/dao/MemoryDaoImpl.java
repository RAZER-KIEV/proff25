package hw7.springnotes.dao;

import hw7.springnotes.dao.MemoryDao;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Роман on 26.06.2015.
 */
@Repository
public class MemoryDaoImpl implements MemoryDao {

    @Autowired
    private SessionFactory factory;

    private static Logger log = Logger.getLogger(hw7.notes.dao.MemoryDaoImpl.class);

    public MemoryDaoImpl() {
    }

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(memory);
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
    public Memory read(Long ig) {
        Session session = factory.openSession();
        Memory memory = null;
        memory = (Memory)session.get(Memory.class, ig);
        session.close();
        log.info(session);
        return memory;
    }

    @Override
    public boolean update(Memory memory) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session = factory.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.delete(memory);
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
    public List<Memory> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from hw7.springnotes.domain.Memory");
        return query.list();
    }
}
