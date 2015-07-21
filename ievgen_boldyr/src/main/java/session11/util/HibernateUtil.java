package session11.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    public static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new Configuration().configure("session11/compHibernate.cfg.xml");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            configuration.setSessionFactoryObserver(
                    new SessionFactoryObserver() {
                        @Override
                        public void sessionFactoryCreated(SessionFactory factory) {}
                        @Override
                        public void sessionFactoryClosed(SessionFactory factory) {
                            ((StandardServiceRegistryImpl) serviceRegistry).destroy();
                        }
                    }
            );
            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.getCurrentSession();
    }
}
