package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ivan on 24.06.15.
 */
@Repository
public class VendorDaoImpl implements VendorDao {

    @Autowired(required = true)
    private SessionFactory factory;

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
    public Vendor read(Long id) {
        return (Vendor) factory.getCurrentSession().get(Vendor.class, id);
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
    public List<Vendor> findAll() {
        Query query = factory.getCurrentSession().createQuery("from Vendor");
        return query.list();
    }

    public List<Vendor> getVendorPorced(int start, int portion) {
        if (start < 0 || portion <= 0 || portion <= start) {
            throw new IllegalArgumentException("ERROR: Input parameters 'start' and 'portion' must be correct.");
        }
        Query query = factory.getCurrentSession().createQuery("from Vendor");
        query.setFirstResult(start);
        query.setMaxResults(portion);
        return query.list();
    }

    public static void main(String[] args) {

    }
}
