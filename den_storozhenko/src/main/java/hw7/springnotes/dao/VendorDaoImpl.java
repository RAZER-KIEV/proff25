package hw7.springnotes.dao;


import hw7.springnotes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class VendorDaoImpl implements VendorDao {
    private static final int STEP_PORCED =10;
    @Autowired
    private SessionFactory factory;

    public VendorDaoImpl(){

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
        Session session = factory.getCurrentSession();
        return (Long)session.save(vendor);
    }

    @Override
    public Vendor read(Long id) {
        Session session = factory.getCurrentSession();
        return (Vendor)session.get(Vendor.class, id);
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = factory.getCurrentSession();
        session.update(vendor);
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = factory.getCurrentSession();
        session.delete(vendor);
        return true;
    }

    public Long getCount(){
        Session session = factory.getCurrentSession();
        return (Long)session.createQuery("select COUNT(v.id) from Vendor v").uniqueResult();
    }

    @Override
    public List<Vendor> getVendorsPorced(int start, int size) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Vendor");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List<Vendor> findAll() {
        List<Vendor> vendors = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            vendors.addAll(getVendorsPorced(i,STEP_PORCED));
        }
        return vendors;
    }
}
