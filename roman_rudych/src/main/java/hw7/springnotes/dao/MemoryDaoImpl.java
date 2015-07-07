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

    public MemoryDaoImpl() {
    }

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) {
        return (Long)factory.getCurrentSession().save(memory);
    }

    @Override
    public Memory read(Long ig) {
        return (Memory)factory.getCurrentSession().get(Memory.class, ig);
    }

    @Override
    public boolean update(Memory memory) {
        boolean result;
        factory.getCurrentSession().update(memory);
        result= true;
        return result;
    }

    @Override
    public boolean delete(Memory memory) {
        boolean result;
        factory.getCurrentSession().delete(memory);
        result = true;
        return result;
    }

    @Override
    public List<Memory> findAll() {
        return factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Memory").list();
    }
}
