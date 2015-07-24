package web.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.domain.Drivers;
import web.domain.Operator;

import java.util.List;

/**
 * Created by george on 21.07.15.
 */
@Repository
public class DriversDaoImpl implements DriversDao {

    @Autowired
    private SessionFactory sessionFactory;

    public DriversDaoImpl() {
    }

    public DriversDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long createDriver(Drivers drivers) {
        return (Long) sessionFactory.getCurrentSession().save(drivers);
    }

    @Override
    public Drivers readDriver(Long id) {
        return (Drivers) sessionFactory.getCurrentSession().get(Operator.class, id);
    }

    @Override
    public boolean updateDriver(Drivers drivers) {
        sessionFactory.getCurrentSession().update(drivers);
        return true;
    }

    @Override
    public boolean deleteDriver(Drivers drivers) {
        sessionFactory.getCurrentSession().delete(drivers);
        return true;
    }

    @Override
    public List<Drivers> listDrivers() {
        Query query = sessionFactory.getCurrentSession().createQuery("from web.domain.Drivers");
        return query.list();
    }
}
