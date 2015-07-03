package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
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
public class CPUDaoImpl implements CPUDao {
    private static final int STEP_PORCED =10;
    @Autowired
    private SessionFactory factory;

    public CPUDaoImpl(){

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
    public Long create(CPU cpu){
        return (Long)factory.getCurrentSession().save(cpu);
    }

    @Override
    public CPU read(Long id) {
        return (CPU)factory.getCurrentSession().get(CPU.class, id);
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

    public Long getCount(){
        return (Long)factory.getCurrentSession().createQuery("select COUNT(c.id) from CPU c").uniqueResult();
    }

    @Override
    public List<CPU> getCpuPorced(int start, int size) {
        Query query = factory.getCurrentSession().createQuery("from CPU");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<CPU> findAll() {
        List<CPU> cpus = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            cpus.addAll(getCpuPorced(i,STEP_PORCED));
        }
        return cpus;
    }
}
