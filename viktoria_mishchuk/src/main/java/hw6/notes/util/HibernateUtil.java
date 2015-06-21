package hw6.notes.util;


import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session10.HiberConnect;

import java.util.Locale;

/**
 * Created by viktoria
 * Project:.hw6.notes.util
 *
 */
public class HibernateUtil {
    private static Logger log = Logger.getLogger(HiberConnect.class);
    SessionFactory factory;

    public HibernateUtil(){

    }

    public void newSesionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
    }

    public void closeSessionFactory(){
        factory.close();
    }
}