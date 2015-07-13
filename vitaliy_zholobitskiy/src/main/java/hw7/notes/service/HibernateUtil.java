package hw7.notes.service;

/**
 * Created by just1ce on 05.07.2015.
 */
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    SessionFactory factory;

    public HibernateUtil(){
    }

    public void createSessionFactory(){
        Configuration cfg = new Configuration().configure("hw6/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void closeFactory(){
        factory.close();
    }
}
