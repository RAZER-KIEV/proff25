package hw6.notes.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by george on 20.06.15.
 */
public class HibernateUtil {
    SessionFactory factory;

    public  HibernateUtil(){
    }

    public void createSessionFactory(){
        Configuration cfg = new Configuration().configure("hw6/dao.notes.cfg.xml");
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
