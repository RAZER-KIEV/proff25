package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ПК on 25.06.2015.
 */

@Repository
public class CPUDaoImpl implements CPUDao {

    @Autowired
    private SessionFactory sessionFactory;

    public CPUDaoImpl(){}

    public CPUDaoImpl(SessionFactory sf) {
        sessionFactory = sf;
    }

    @Override
    public Long create(CPU cpu) {
        System.out.println(sessionFactory);
        Long id = (Long) sessionFactory.getCurrentSession().save(cpu);
        return id;
    }

    @Override
   // @Transactional( readOnly = true)
    public CPU read(Long id) {
        CPU cpu = (CPU) sessionFactory.getCurrentSession().get(CPU.class, id);
        return cpu;
    }

    @Override
    public boolean update(CPU cpu) {
        boolean upres;
        sessionFactory.getCurrentSession().save(cpu);
        if(read(cpu.getId()).equals(cpu)) return  true;
        else return false;


    }

    @Override
    public boolean delete(CPU cpu) {
    sessionFactory.getCurrentSession().delete(cpu);
        if(read(cpu.getId())==(cpu)) return  false;
        else return true;

    }
   // @Transactional(readOnly = true)
    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM CPU");
        return query.list();
    }
}
