package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 */
@Repository
public class CPUDaoImpl implements CPUDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU cpu) {
        return (long) factory.getCurrentSession().save(cpu);
    }

    @Override
    public CPU read(Long id) {
        return (CPU) factory.getCurrentSession().get(CPU.class, id);
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
    public List<CPU> findAll() {
        Query query = factory.getCurrentSession().createQuery("from CPU");
        return query.list();
    }

    public List<CPU> getCPUPorced(int start, int portion) {
        if (start < 0 || portion <= 0 || portion <= start) {
            throw new IllegalArgumentException("ERROR: Input parameters 'start' and 'portion' must be correct.");
        }
        Query query = factory.getCurrentSession().createQuery("from CPU");
        query.setFirstResult(start);
        query.setMaxResults(portion);
        return query.list();
    }


    public static void main(String[] args) {

    }
}
