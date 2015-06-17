package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by bosyi on 16.06.15.
 */
public class RegionHibernateDaoImpl implements RegionDao {
    private static Logger log = Logger.getLogger(HiberConnect.class);
    private SessionFactory factory;

    public RegionHibernateDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    @Override
    public Long create(Region region) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(region);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException ex) {
            log.error("Transaction failed");
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Region read(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Region region = (Region) session.get(Region.class, id);
            session.getTransaction().commit();
            return region;
        } catch (HibernateException ex) {
            log.error("Transaction failed");
        } finally {
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
        } catch (HibernateException ex) {
            log.error("Transaction failed", ex);
        } finally {
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
        } catch (HibernateException ex) {
            log.error("Transaction failed");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Region> findAll() {
        Session session = factory.openSession();
        return session.createQuery("from Region ").list();
    }

    @Override
    public List<Region> findByName(String regionName) {
        Session session = factory.openSession();
        return session.createQuery("from Region as reg where reg.regionName = '"+regionName+"'").list();
    }

    @Override
    public List<Region> findByIdRange(Long beginId, Long endId) {
        Session session = factory.openSession();
        return session.createQuery("from Region as reg where reg.id >= "+beginId+" and reg.id <= "+endId+"").list();

    }

    @Override
    public void partialShow(Long start, Long quantity) {
        Session session = factory.openSession();
        long totalNumberOfRows = (Long) session.createQuery("select count(r) from Region r").uniqueResult();
        System.out.println(totalNumberOfRows);
        session.close();
    }

    @Override
    public Long getCount() {
        Session session = factory.openSession();
        Long totalNumberOfRows = null;
        try {
            totalNumberOfRows = (Long) session.createQuery("select count(r) from Region r").uniqueResult();
            return totalNumberOfRows;
        } catch (HibernateException ex) {

        } finally {
            session.close();
        }
        return totalNumberOfRows;
    }
}
