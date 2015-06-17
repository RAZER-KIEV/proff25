package week5_lesson9;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.Locale;
@Entity
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

        Session session = null;
        try {
            session = factory.openSession();
            Region region =(Region)session.get(Region.class, 1L);
            System.out.println(region.toString());
            session.beginTransaction();

            Long id =(Long)session.save(new Region("Антарктида"));
            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();}
        }
        log.info(session);
        factory.close();
    }
}