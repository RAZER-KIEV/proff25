package web.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.domain.Drivers;

import java.util.List;

/**
 * Created by george on 21.07.15.
 */
@Repository
public class DriversDaoImpl implements DriversDao{


    @Autowired
    private SessionFactory sessionFactory;

    public DriversDaoImpl() {
    }

    public DriversDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Drivers> listDrivers() {
        Query query = sessionFactory.getCurrentSession().createQuery("from web.domain.Drivers");
        return query.list();
    }
}
