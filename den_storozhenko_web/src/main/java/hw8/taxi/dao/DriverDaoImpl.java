package hw8.taxi.dao;

import hw8.taxi.domain.Driver;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DriverDaoImpl implements DriverDao {
    //@Qualifier("sessionFactory")
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
    public Driver readByPhone(String phone) {
        Query query = factory.getCurrentSession().createQuery("from Driver d where d.phone=:phone");
        query.setParameter("phone",phone);
        return (Driver)query.uniqueResult();
    }

    @Override
    public boolean authenticate(String phone, String password) {
        Query query = factory.getCurrentSession().createQuery("from Driver d where d.phone=:phone and d.password=:password");
        query.setParameter("phone",phone);
        query.setParameter("password",password);
        return !query.list().isEmpty();
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
