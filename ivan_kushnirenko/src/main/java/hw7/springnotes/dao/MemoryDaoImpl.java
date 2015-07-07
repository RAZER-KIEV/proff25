package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 */
@Repository
public class MemoryDaoImpl implements MemoryDao {

    @Autowired(required = true)
    private SessionFactory factory;

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
    public Memory read(Long id) {
        return (Memory) factory.getCurrentSession().get(Memory.class, id);
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
    public List<Memory> findAll() {
        Query query = factory.getCurrentSession().createQuery("from Memory");
        return query.list();
    }

    public List<Memory> getMemoryPorced(int start, int portion) {
        if (start < 0 || portion <= 0 || portion <= start) {
            throw new IllegalArgumentException("ERROR: Input parameters 'start' and 'portion' must be correct.");
        }
        Query query = factory.getCurrentSession().createQuery("from Memory");
        query.setFirstResult(start);
        query.setMaxResults(portion);
        return query.list();
    }

    public static void main(String[] args) {

    }

}
