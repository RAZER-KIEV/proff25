package scrum.taxi.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import scrum.taxi.domain.Driver;

import java.util.List;

@Repository
public class DriverDaoImpl implements DriverDao {
    @Autowired
    private SessionFactory factory;

    public DriverDaoImpl() {
    }

    public DriverDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Driver driver) {
        return (Long)factory.getCurrentSession().save(driver);
    }

    @Override
    public Driver read(Long id) {
        return (Driver)factory.getCurrentSession().get(Driver.class, id);
    }

    @Override
    public boolean update(Driver driver) {
        factory.getCurrentSession().update(driver);
        return true;
    }

    @Override
    public boolean delete(Driver driver) {
        factory.getCurrentSession().delete(driver);
        return true;
    }

    @Override
    public List<Driver> findAll() {
        return factory.getCurrentSession().createQuery("from Driver").list();
    }
}
