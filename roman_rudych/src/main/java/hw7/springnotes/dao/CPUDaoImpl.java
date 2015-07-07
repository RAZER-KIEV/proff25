package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
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
public class CPUDaoImpl implements CPUDao {

    @Autowired
    private SessionFactory factory;

    public CPUDaoImpl() {}

    public CPUDaoImpl(SessionFactory factory) {
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
        boolean result;
        factory.getCurrentSession().update(cpu);
        result = true;
        return result;
    }

    @Override
    public boolean delete(CPU cpu) {
        boolean result;
        factory.getCurrentSession().delete(cpu);
        result = true;
        return result;
    }

    @Override
    public List<CPU> findAll() {
        return factory.getCurrentSession().createQuery("from hw7.springnotes.domain.CPU").list();
    }
}
