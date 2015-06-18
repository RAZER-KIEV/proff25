package session10;

import javax.persistence.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by george on 15.06.15.
 */
public class HiberConnect {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
//            Serializable id;
//            Region region = (Region)session.get(Region.class, id);
            session.beginTransaction();
            session.save(new Region());
//            Long id = (Long)session.save(new Region());
//            session.update(region);
//            session.delete(region);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            //в случае отмены то откатываем все наши изменения.
//            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
        System.exit(0);
    }
}
