package hw7.springnotes.dao;

import hw7.springnotes.dao.VendorDao;
import hw7.springnotes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Роман on 26.06.2015.
 */
@Repository
public class VendorDaoImpl implements VendorDao {

    @Autowired
    private SessionFactory factory;

    public VendorDaoImpl() {
    }

    public VendorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Vendor vendor) {
        return (Long)factory.getCurrentSession().save(vendor);
    }

    @Override
    public Vendor read(Long ig) {
        return (Vendor)factory.getCurrentSession().get(Vendor.class, ig);
    }

    @Override
    public boolean update(Vendor vendor) {
        boolean result;
        factory.getCurrentSession().update(vendor);
        result = true;
        return result;
    }

    @Override
    public boolean delete(Vendor vendor) {
        boolean result;
        factory.getCurrentSession().delete(vendor);
        result = true;
        return result;
    }

    @Override
    public List<Vendor> findAll() {
        return factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Vendor").list();
    }
}
