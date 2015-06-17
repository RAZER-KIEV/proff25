package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        Session session = null;
        SessionFactory factory = null;

        try {

            factory = cfg.buildSessionFactory(standardServiceRegistry);
            log.info("Reference to SessionFactory " + factory);

            session = factory.openSession();
            session.beginTransaction();
            Region region = new Region("Antarctic");
            session.save(region);

            region.setName("Antarctica");
            session.update(region);

            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null){
                factory.close();
            }
        }
        log.info(session);
    }
}

