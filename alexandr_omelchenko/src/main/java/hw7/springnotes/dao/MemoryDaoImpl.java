package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MemoryDaoImpl implements MemoryDao {
    @Autowired
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
    return (Long)factory.getCurrentSession().save(memory);
    }
    @Override
    public Memory read(Long id) {
        return (Memory)factory.getCurrentSession().get(Memory.class, id);
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
        List<Memory>list;
        list =factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Memory").list();
        return list;
    }
}
