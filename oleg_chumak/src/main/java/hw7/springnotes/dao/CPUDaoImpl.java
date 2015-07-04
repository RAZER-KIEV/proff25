package hw7.springnotes.dao;

import hw7.springnotes.dao.CPUDao;
import hw7.springnotes.domain.CPU;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by oleg on 25.06.15.
 */
@Repository
public class CPUDaoImpl implements CPUDao {
    @Autowired
    private SessionFactory factory;

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

    public CPUDaoImpl() {
    }
}
