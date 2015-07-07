package session14.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.domain.Company;
import session14.domain.Employee;

/**
 * Created by ivan on 23.06.15.
 */
public class HibernateUtil {

    public SessionFactory createSessionFactory(){
        Configuration cfg = new Configuration()
                .addAnnotatedClass(session14.domain.Company.class)
                .addAnnotatedClass(Employee.class)
                .configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        return factory;
    }
}
