package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;

/**
 * Created by ivan on 16.06.15.
 */
public class RegionHibernateDaoImpl implements RegionDao{

    private static Logger log = Logger.getLogger(RegionHibernateDaoImpl.class); // Логгируем нашу работу

    private SessionFactory factory;


    RegionHibernateDaoImpl(){
        Locale.setDefault(Locale.ENGLISH);
    }

    public void init(){
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Region.class)
                .configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
    }

    @Override
    public Long create(Region region) {
        if (factory==null){
            this.init();
        }
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(region);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            e.printStackTrace();
            session.close();
            factory.close();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        factory.close();
        return id;
    }

    @Override
    public Region read(Long id) {
        if (factory==null){
            this.init();
        }
        Session session = factory.openSession();
        try {
            return (Region)session.get(Region.class, id);
        } catch(HibernateException e) {
            log.error("READ FAILED", e);
            e.printStackTrace();
            session.close();
            factory.close();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Region region) {
        if (factory==null){
            this.init();
        }
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(region);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Transaction failed");
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void delete(Region region) {
        if (factory==null){
            this.init();
        }
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(region);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Region> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from session10.Region");
        return query.list();
    }

    @Override
    public List<Region> findRegionById(Long id) {
        Session session = factory.openSession();
        Query query = session.createQuery("from session10.Region r where r.id="+id);
        return query.list();
    }

    public void getPortionOfRegions() {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select c.name from session10.Region c");
            for (int i = 0; i<3; i++) {
                query.setFirstResult(i*2);
                query.setMaxResults(2);
                System.out.println(query.list());
            }
        } catch (HibernateException e){
            log.error("Transaction failed");
            e.printStackTrace();
        } finally {
            if (session!=null){
                session.close();
            }
        }
    }

    public static void main(String[] args) {
        RegionHibernateDaoImpl rhdi = new RegionHibernateDaoImpl();
        rhdi.init();
//        List<Region> regions = rhdi.findAll();
//        System.out.println(regions);
//        regions = rhdi.findRegionById(3L);
//        System.out.println(regions);
//        Region ukraine = new Region();
//        ukraine.setName("ukraine");
//        rhdi.create(ukraine);
        Region tmp = (Region) rhdi.read(3L);
        System.out.println(tmp);
//        tmp.setName("newRegion");
        rhdi.getPortionOfRegions();
//        List<Region> regions =
//        rhdi.getPortionOfRegions();
//        System.out.println(regions);
        rhdi.factory.close();
    }
}
