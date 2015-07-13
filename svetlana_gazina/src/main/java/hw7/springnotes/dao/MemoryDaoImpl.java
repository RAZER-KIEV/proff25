package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sveta on 7/5/2015.
 */
@Repository
@Transactional
public class MemoryDaoImpl implements MemoryDao {
    @Autowired(required = true)
    private SessionFactory factory;

    public MemoryDaoImpl() {
    }
    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {

        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) {
        return (Long) factory.getCurrentSession().save(memory);
    }

    @Override
    public Memory read(Long ig) {
        return (Memory) factory.getCurrentSession().get(Memory.class, ig);
    }

    @Override
    public boolean update(Memory memory) {
        factory.getCurrentSession().update(memory);
        return true;
    }

    @Override
    public boolean delete(Memory memory) {
        factory.getCurrentSession().delete(memory);
        return true;
    }

    @Override
    public List findAll() {
        Query query = factory.getCurrentSession().createQuery("from Memory ");
        return query.list();
    }
}
