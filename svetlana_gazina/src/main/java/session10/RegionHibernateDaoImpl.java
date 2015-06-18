package session10;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Sveta on 6/16/2015.
 */
public class RegionHibernateDaoImpl implements RegionDao {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HiberConnect.class);
    private SessionFactory factory;

    public RegionHibernateDaoImpl(SessionFactory factory) {
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

        } catch (HibernateException e) {
            log.error("Open session failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return id;
    }

    @Override
    public void update(Region region) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(region);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.error("Open session failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }


    }

    @Override
    public Region read(Long id) {
        Session session = factory.openSession();
        try {
            return (Region) session.get(Region.class, id);

        } catch (HibernateException e) {
            log.error("Open session failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return null;
    }

    @Override
    public void delete(Region region) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(region);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.error("Open session failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }

    }

    @Override
    public List<Region> findAll() {

        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from session10.Region");
        return query.list();


    }

    @Override
    public List<Region> findByName(String name) {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from session10.Region r" +
                " where r.name = name ");

        return query.list();

    }

    @Override
    public List<Region> findByIdRange(Long idFrom, Long idTo) {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from session10.Region r" +
                " where r.id >= :idFrom and r.id <= :idTo ");
        query.setParameter("idTo", idTo);
        query.setParameter("idFrom", idFrom);

        return query.list();
    }

    @Override
    public List<Region[]> findByPortions(Integer beginFrom, Integer PortionSize) {
        Session session = factory.openSession();
        Query query = (Query) session.createQuery("from session10.Region");
        query.setFirstResult(beginFrom);
        query.setMaxResults(PortionSize);
        return (List<Region[]>)query.list();
    }


}
