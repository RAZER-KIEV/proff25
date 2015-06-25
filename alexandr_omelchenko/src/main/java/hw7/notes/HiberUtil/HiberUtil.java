package hw7.notes.HiberUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by HP on 25.06.2015.
 */
public class HiberUtil {
    private SessionFactory factory;
    public SessionFactory initialize(){
        Configuration cfg = new Configuration().configure("hw7/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
        return factory;
    }
    public void factoryClose(){
        factory.close();
    }
}
