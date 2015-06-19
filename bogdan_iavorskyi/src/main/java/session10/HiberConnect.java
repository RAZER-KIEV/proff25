package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public class HiberConnect {

    private static Logger log = Logger.getLogger(HiberConnect.class);
    private SessionFactory factory;
    private Session session;

    public HiberConnect() {
        Locale.setDefault(Locale.ENGLISH);
    }

    public void openFactory() {
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
    }

    public void closeFactory() {
        factory.close();
    }

    public void openSession() {
        session = factory.openSession();
    }

    public void closeSession() {
        session.close();
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commitTransaction() {
        session.getTransaction().commit();
    }

    public void insert(String name) {
        insert(new Region(name));
    }

    public void insert(Region region) {
        session.save(region);
    }

    public void update(String currentName, String replaceName) {
        List<Region> regions = session.createSQLQuery("SELECT * FROM REGIONS WHERE REGION_NAME = '"+currentName+"'").addEntity(Region.class).list();
        for(Region region:regions) {
            region.setRegionName(replaceName);
            session.update(region);
        }
    }

    public void update(Long id, String replaceName) {
        update(id, new Region(replaceName));
    }

    public void update(Long id, Region region) {
        region.setId(id);
        session.update(region);
    }

    public void delete(String regionName) {
        delete(new Region(regionName));
    }

    public void delete(Region region) {
        session.delete(region);
    }

    /*public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();

            session.beginTransaction();
            session.save(new Region("Antarktika"));
            session.getTransaction().commit();


        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        factory.close();
    }*/

}

