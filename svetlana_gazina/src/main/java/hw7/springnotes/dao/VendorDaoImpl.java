package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sveta on 7/5/2015.
 */
@Repository
@Transactional
public class VendorDaoImpl implements VendorDao {
    @Autowired(required = true)
    private SessionFactory factory;

    public VendorDaoImpl() {
    }
    public VendorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {

        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Vendor vendor) {
        return (Long) factory.getCurrentSession().save(vendor);
    }

    @Override
    public Vendor read(Long ig) {
        return (Vendor) factory.getCurrentSession().get(Vendor.class, ig);
    }

    @Override
    public boolean update(Vendor vendor) {
        factory.getCurrentSession().update(vendor);
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        return false;
    }

    @Override
    public List findAll() {
        Query query = factory.getCurrentSession().createQuery("from Vendor ");
        return query.list();
    }
}
