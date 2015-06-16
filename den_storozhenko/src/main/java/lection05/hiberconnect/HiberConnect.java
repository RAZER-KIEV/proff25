package lection05.hiberconnect;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;


public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);
    private SessionFactory factory;
    private Session session;

    public HiberConnect(){
        Locale.setDefault(Locale.ENGLISH);
    }

    public void init(){
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
    }

    public void openSession(){
        if ((session = factory.openSession())==null)
            throw  new HibernateException("Session does not created.");
    }

    public void closeSession(){
        if (session!=null) {
            session.close();
        }
        log.info(session);
    }

    public void closeFactory(){
        factory.close();
    }

    public void beginTransaction(){
        session.beginTransaction();
    }

    public void commit(){
        session.getTransaction().commit();
    }

    public void delete(Region region){
        session.delete(region);
    }

    public void delete(Long id){
        System.err.println(id);
        session.delete((Region)session.get(Region.class,id));
    }

    public void delete(String name){
        List<Region> regionList = session.createSQLQuery("SELECT * FROM REGIONS WHERE REGION_NAME='" + name + "'").addEntity(Region.class).list();
        for (Region region:regionList){
            session.delete(region);
        }
    }

    public void save(String name){
        session.save(new Region(name));
    }

    public void save(Region region){
        session.save(region);
    }

    public void update(String what, String to){
        List<Region> regionList = session.createSQLQuery("SELECT * FROM REGIONS WHERE REGION_NAME='"+what+"'").addEntity(Region.class).list();
        for(Region region:regionList) {
            region.setName(to);
            session.update(region);
        }
    }

    public void update(Long id, String to){
        Region region = (Region)session.get(Region.class,id);
        region.setName(to);
        session.update(region);
    }

    /*public static void main(String[] args) throws InterruptedException {
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

            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        factory.close();
    }*/
}

