package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ПК on 25.06.2015.
 */
public class VendorDaoImpl implements VendorDao{
    private SessionFactory sessionFactory;

    public VendorDaoImpl(){}
    public VendorDaoImpl(SessionFactory sf){
        sessionFactory=sf;
    }
    @Override
    public Long create(Vendor vendor) {
        Session session = sessionFactory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(vendor);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not saved!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public Vendor read(Long id) {
        Session session = sessionFactory.openSession();
        Vendor nbk = null;
        try {
            nbk = (Vendor) session.get(Vendor.class,id);
        }catch (HibernateException hEx){
            System.out.println("Exception: Not readed!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

        return nbk;

    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = sessionFactory.openSession();
        boolean upres = false;
        try {
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
            upres = true;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not updated!");
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return upres;

    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = sessionFactory.openSession();
        boolean res;
        try {
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
            res = true;
        }catch (HibernateException hEx){
            session.getTransaction().rollback();
            System.out.println("Exception: Not deleted!");
            hEx.printStackTrace();
            res = false;
        }finally {
            if (session !=null)
                session.close();
        }
        return res;
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Vendor");
        return query.list();
    }
}
