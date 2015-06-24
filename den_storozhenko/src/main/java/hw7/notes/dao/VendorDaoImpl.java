package hw7.notes.dao;


import hw7.notes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class VendorDaoImpl implements VendorDao {
    private static final int STEP_PORCED =10;
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
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(vendor);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
                session.close();
        }
        return id;
    }

    @Override
    public Vendor read(Long id) {
        Session session = factory.openSession();
        try{
            return (Vendor)session.get(Vendor.class,id);
        }catch (HibernateException e){
            return null;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }finally {
            if (session!=null)
                session.close();
        }
    }

    public Long getCount(){
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select COUNT(v.id) from Vendor v");
            return (Long) query.uniqueResult();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Vendor> getVendorsPorced(int start, int size) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Vendor");
            query.setFirstResult(start);
            query.setMaxResults(size);
            return query.list();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Vendor> findAll() {
        List<Vendor> cpus = new ArrayList<>();
        Long count = getCount();
        for (int i=0;i<count;i+=STEP_PORCED){
            cpus.addAll(getVendorsPorced(i,STEP_PORCED));
        }
        return cpus;
    }
}
