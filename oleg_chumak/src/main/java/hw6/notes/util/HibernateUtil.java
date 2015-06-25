package hw6.notes.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by oleg on 17.06.15.
 */
public class HibernateUtil {
    SessionFactory factory;

    public HibernateUtil() {
    }

    public void createSessionFactory() {
        System.out.println("1");
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void closeFactory() {
        factory.close();
    }
}