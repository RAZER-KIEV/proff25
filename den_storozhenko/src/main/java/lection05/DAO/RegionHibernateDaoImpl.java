package lection05.DAO;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class RegionHibernateDaoImpl implements RegionDao {
    private static Logger log = Logger.getLogger(RegionHibernateDaoImpl.class);
    private SessionFactory factory;

    public RegionHibernateDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Region region) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(region);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
                session.close();
        }
        return id;
    }

    @Override
    public Region read(Long id) {
        Session session = factory.openSession();
        try{
            return (Region)session.get(Region.class,id);
        }catch (HibernateException e){
            log.error("Transaction failed");
        }finally {
            if (session!=null)
                session.close();
        }
        return null;
    }

    @Override
    public void update(Region region) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(region);
            session.getTransaction().commit();
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public void delete(Region region) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(region);
            session.getTransaction().commit();
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    public List<Region> findAll() {
        Session session = factory.openSession();
        return session.createQuery("from Region").list();
    }

    @Override
    public List<Region> find(String name) {
        Session session = factory.openSession();
        return session.createQuery("from Region r where r.name = '"+name+"'").list();
    }

    @Override
    public List<Region> findID(Long startID, Long finishID) {
        Session session = factory.openSession();
        return session.createQuery("from Region r where r.id >= "+startID+" and r.id<="+finishID).list();
    }

    @Override
    public List<String> getNamesAllRegionsPorced(int start, int size) {
        Session session = factory.openSession();
        Query query = session.createQuery("select r.name from Region r");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    public Long getCount(){
        Session session = factory.openSession();
        Query query = session.createQuery("select COUNT(r.id) from Region r");
        return (Long)query.uniqueResult();
    }
}
