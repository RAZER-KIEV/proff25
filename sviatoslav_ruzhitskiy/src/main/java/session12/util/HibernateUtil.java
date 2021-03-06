package session12.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by ПК on 18.06.2015.
 */
public class HibernateUtil {

   private static HibernateUtil instance;

    private SessionFactory sessionFactory;

    private static Logger log = Logger.getLogger(HibernateUtil.class);

    public static HibernateUtil getInstance(){
        if (instance == null){
            return new HibernateUtil();
        } return instance;
    }

    private HibernateUtil(){}

    public SessionFactory connectToHib(){
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + sessionFactory);

        return sessionFactory;
    }
    public SessionFactory getExistingSessionFactory(){return sessionFactory;}
}
