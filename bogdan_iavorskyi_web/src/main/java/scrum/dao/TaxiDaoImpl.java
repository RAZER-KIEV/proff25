package scrum.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 14.07.2015.
 */
public class TaxiDaoImpl implements TaxiDao  {
    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(Taxi taxi) {
        return (Long) factory.getCurrentSession().save(taxi);
    }

    @Override
    public Taxi read(Long id) {
        return (Taxi) factory.getCurrentSession().get(Taxi.class, id);
    }

    @Override
    public void update(Taxi taxi) {
        factory.getCurrentSession().update(taxi);
    }

    @Override
    public void delete(Taxi taxi) {
        factory.getCurrentSession().delete(taxi);
    }

    @Override
    public List listAll() {
        return factory.getCurrentSession().createQuery("from Taxi as c").list();
    }

}
