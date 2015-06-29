package hw7.notes.util;

/**
 * Created by george on 27.06.15.
 */
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
        Configuration cfg = new Configuration().configure("hw7.notes/hibernate.cfg.xml");
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
