package Taxi.Dao;

import Taxi.Domain.Taxi;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jul on 14.07.2015.
 */
@Repository

public class TaxiDaoImpl implements TaxiDao {

    @Autowired
    private SessionFactory factory;

    public TaxiDaoImpl() {
    }

    public TaxiDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Taxi taxi) {
        return (Long) factory.getCurrentSession().save(taxi);
    }

    @Override
    public Taxi read(Long id) {
        return (Taxi) factory.getCurrentSession().get(Taxi.class, id);
    }

    @Override
    public boolean update(Taxi taxi) {
        factory.getCurrentSession().update(taxi);
        return true;
    }

    @Override
    public boolean delete(Taxi taxi) {
        factory.getCurrentSession().delete(taxi);
        return true;
    }

    @Override
    public List findAll() {
        List<Taxi> list;
        list = factory.getCurrentSession().createQuery("from Taxi.Domain.Taxi").list();
        return list;
    }
}
