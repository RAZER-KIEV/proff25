package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MemoryDaoImpl implements MemoryDao {
    private static final int STEP_PORCED =10;
    @Autowired
    private SessionFactory factory;

    public MemoryDaoImpl(){

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

    public Long getCount(){
        return (Long)factory.getCurrentSession().createQuery("select COUNT(m.id) from Memory m").uniqueResult();
    }

    @Override
    public List<Memory> getMemoriesPorced(int start, int size) {
        Query query = factory.getCurrentSession().createQuery("from Memory");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<Memory> findAll() {
        List<Memory> memories = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            memories.addAll(getMemoriesPorced(i, STEP_PORCED));
        }
        return memories;
    }
}
