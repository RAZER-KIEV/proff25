package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CPUDaoImpl implements CPUDao {
    @Autowired
    private SessionFactory factory;

    public CPUDaoImpl() {
    }
    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU processor) {
       return (Long)factory.getCurrentSession().save(processor);
    }
    @Override
    public CPU read(Long id) {
        return (CPU)factory.getCurrentSession().get(CPU.class, id);
    }
    @Override
    public boolean update(CPU processor) {
       factory.getCurrentSession().delete(processor);
            return true;
    }
    @Override
    public boolean delete(CPU processor) {
        factory.getCurrentSession().update(processor);
        return true;
    }
    @Override
    public List findAll() {
        List<CPU>list;
        list =factory.getCurrentSession().createQuery("from hw7.springnotes.domain.CPU").list();
        return list;
    }
}