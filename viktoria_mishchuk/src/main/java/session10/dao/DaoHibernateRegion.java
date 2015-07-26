package session10.dao;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session10.Region;

import java.util.List;


/**
 * Created by viktoria
 * Project:.session10
 */
public class DaoHibernateRegion implements DaoRegion {
    private static Logger log =Logger.getLogger(String.valueOf(DaoHibernateRegion.class));
    private SessionFactory factory;

    public DaoHibernateRegion(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create (Region region){
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(region);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return id;
    }

    @Override
    public Region read(Long id) {
        Session session = factory.openSession();
        try {
            return (Region)session.get(Region.class, id);
        }catch (HibernateException e) {
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
            session.update(region.getId());
            session.getTransaction().commit();
        }catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Region region) {
        Session session = factory.openSession();
        try {
            session.delete(region);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Region> findAll(){
        Session session = factory.openSession();
        Query query = session.createQuery("from Region");
        return query.list();

    }

    @Override
    public List<Region> findRegionByName(Region region){
        Session session = factory.openSession();
        Query query = session.createQuery("from Regions where region_name= :xxx ");
        query.setParameter( "xxx", region);
        return query.list();
    }

    @Override
    public List<Region> findRegionById(Long id1, Long id2){
        Session session = factory.openSession();
        Query query = session.createQuery("from Regions where region_id between :id1 and :id2");
        query.setParameter("id1", id1);
        query.setParameter("id2", id2);
        return query.list();

    }

    @Override
    public List<Region> RegionPortion(int id, int size){
        Session session = factory.openSession();
        Query query = session.createQuery(" select r.region_name from Regions r");
        query.setFirstResult(id);
        query.setMaxResults(size);
        List result = query.list();
        return result;
    }

}
