package lection06;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

public class HibernateUtil {
    SessionFactory factory;

    public HibernateUtil(){
        Locale.setDefault(Locale.ENGLISH);
    }

    public void createSessionFactory(){
        Configuration cfg = new Configuration().configure("lection06\\dao.company.cfg.xml");
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
