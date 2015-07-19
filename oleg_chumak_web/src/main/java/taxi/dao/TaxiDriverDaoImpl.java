package taxi.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taxi.domain.TaxiDriver;
import java.util.List;

/**
 * Created by HP on 16.07.2015.
 */
@Repository
public class TaxiDriverDaoImpl implements TaxiDriverDao {
    @Autowired

    private SessionFactory factory;

    public TaxiDriverDaoImpl() {
    }
    public TaxiDriverDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public TaxiDriver read(Long id) {
        return (TaxiDriver)factory.getCurrentSession().get(TaxiDriver.class, id);
    }

    @Override
    public Long create(TaxiDriver taxiDriver) {
        return (Long)factory.getCurrentSession().save(taxiDriver);
    }

    @Override
    public boolean update(TaxiDriver taxiDriver) {
         factory.getCurrentSession().update(taxiDriver);
        return true;
    }

    @Override
    public boolean delete(TaxiDriver taxiDriver) {
        factory.getCurrentSession().delete(taxiDriver);
        return false;
    }

    @Override
    public List findAll() {
        List<TaxiDriver>list;
        list =factory.getCurrentSession().createQuery("from taxi.domain.TaxiDriver").list();
        return list;
    }
}
