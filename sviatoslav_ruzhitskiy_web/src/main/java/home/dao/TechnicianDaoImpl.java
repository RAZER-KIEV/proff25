package home.dao;

import home.domain.Technician;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ПК on 03.12.2015.
 */
@Repository
public class TechnicianDaoImpl implements TechnicianDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Technician tech) {
        return (Long)sessionFactory.getCurrentSession().save(tech);
    }

    @Override
    public Technician read(Long id) {
        return (Technician)sessionFactory.getCurrentSession().get(Technician.class, id);
    }

    @Override
    public boolean update(Technician tech) {
        sessionFactory.getCurrentSession().update(tech);
        return true;
    }

    @Override
    public boolean delete(Technician tech) {
        sessionFactory.getCurrentSession().delete(tech);
        return true;
    }

    @Override
    public Technician searchByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Technician c where c.login=:login");
        query.setParameter("login",login);
        return (Technician)query.uniqueResult();
    }

    @Override
    public Long getDBSize() {
        Long size = (Long) sessionFactory.getCurrentSession().createQuery("select COUNT(c.id) from Technician c").uniqueResult();
        System.out.println("getDBSize: "+size);
        return size;
    }

    @Override
    public List findAll() {
        List<Technician> techs;
        Query query = sessionFactory.getCurrentSession().createQuery("from Technician");
        techs = query.list();
        return techs;
    }
}
