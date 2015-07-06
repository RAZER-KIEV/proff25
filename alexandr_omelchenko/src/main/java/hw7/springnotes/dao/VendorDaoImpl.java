package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class VendorDaoImpl implements VendorDao {
    @Autowired
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
    public Long create(Vendor vendor)
    {
        return (Long)factory.getCurrentSession().save(vendor);
    }

    @Override
    public Vendor read(Long id)  {
        return (Vendor)factory.getCurrentSession().get(Vendor.class, id);
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
        List<Vendor>list;
        list =factory.getCurrentSession().createQuery("from hw7.springnotes.domain.Vendor").list();
        return list;
    }
}
