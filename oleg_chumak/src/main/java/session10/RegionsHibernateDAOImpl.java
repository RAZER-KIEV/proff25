package session10;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 16.06.15.
 */
public class RegionsHibernateDAOImpl implements RegionDao {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    private SessionFactory factory;

    public RegionsHibernateDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Region region) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(region);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException except){
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Region read(Long id) {
        Session session = factory.openSession();
        try {
            return  (Region) session.get(Region.class, id);
        } catch (HibernateException except){
            session.getTransaction().rollback();
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
        } catch (HibernateException except){
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Region region){
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.delete(region);
            session.getTransaction().commit();
        } catch (HibernateException except){
                        log.error("Open session failed", except);
//            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public RegionsHibernateDAOImpl() {
    }

    @Override
    public List<Region> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Region ");
        return query.list();
    }

    @Override
    public List<Region> findByName(String name) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Region c where (c.name = '"+name+"')");
        return query.list();
    }

    @Override
    public List<Region> findById(Long firstId, Long lastId) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Region c where " +
                "(c.id >= "+firstId+" and c.id <= "+lastId+")");
        return query.list();
    }

    @Override
    public List<Region> findAllbyPortions(Long start, Long range) {
        List<Region> list = new ArrayList<>();
        Session session = factory.openSession();
        String qu = "select count(id) from Region";
        Query query = session.createQuery(qu);
        Long size = (Long)query.uniqueResult();
//            for (Long i = start; i <= iterations; i++){
//                list.add(read(i));
//            }
        return null;
    }
}
