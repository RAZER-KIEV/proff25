package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Jeckgehor on 16.06.2015.
 */
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
        } finally {
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
}
