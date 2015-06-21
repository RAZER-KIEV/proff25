package hw6.notes.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by HP on 20.06.2015.
 */
public class HibernateUtil {
    private SessionFactory factory;

    public void initialize() {
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);}

    public void factoryClose() {
        factory.close();
    }

    public SessionFactory getFactory() {return factory;}
    public void setFactory(SessionFactory factory) {this.factory = factory;}
}