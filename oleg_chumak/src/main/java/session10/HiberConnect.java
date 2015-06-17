package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 15.07.15
 */
public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
//        Session session = null;
//        try {
//            session = factory.openSession();
//            session.beginTransaction();
//            session.save(reg);
//            session.getTransaction().commit();
//            session.beginTransaction();
//            Region region = (Region)session.get(Region.class, 5);
//            System.out.println(region.getName());
//            region.setName("Antarktika");
//            session.update(region);
//            session.getTransaction().commit();
//            session.beginTransaction();
//            Region region1 = (Region) session.get(Region.class, 5);
//            System.out.println(region1.getName());
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            log.error("Open session failed", e);
//            session.getTransaction().rollback();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        log.info(session);
        RegionsHibernateDAOImpl dao = new RegionsHibernateDAOImpl(factory);
//        Region tmp = dao.read();
        System.out.println(dao.findById(new Long(2), new Long(4)));
    }
}

