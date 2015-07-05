package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
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
public class CPUDaoImpl implements CPUDao {
    @Autowired(required = true)
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
    public Long create(CPU cpu) {
        return (Long)factory.getCurrentSession().save(cpu);
    }

    @Override
    public CPU read(Long ig) {
        return (CPU)factory.getCurrentSession().get(CPU.class, ig);
    }

    @Override
    public boolean update(CPU cpu) {
        factory.getCurrentSession().update(cpu);
        return true;
    }

    @Override
    public boolean delete(CPU cpu) {
        factory.getCurrentSession().delete(cpu);
        return true;
    }

    @Override
    public List findAll() {
        Query query = factory.getCurrentSession().createQuery("from CPU ");
        return query.list();
    }
}
