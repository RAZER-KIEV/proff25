package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
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
 * Created by oleg on 24.06.15.
 */
@Repository
public class VendorDaoImpl implements VendorDao {
    @Autowired
    private SessionFactory factory;

    public VendorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }
    public VendorDaoImpl() {    }

    @Override
    public Long create(Vendor vendor) {
        Session session = factory.getCurrentSession();
        return (Long)session.save(vendor);
    }

    @Override
    public Vendor read(Long ig) {
        Session session = factory.getCurrentSession();
        return (Vendor)session.get(Vendor.class, ig);
    }

    @Override
    public boolean update(Vendor vendor) {
        factory.getCurrentSession().update(vendor);
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        factory.getCurrentSession().delete(vendor);
        return true;
    }

    @Override
    public List findAll() {
        Query query = factory.getCurrentSession().createQuery("from Vendor");
        return query.list();
    }
}
