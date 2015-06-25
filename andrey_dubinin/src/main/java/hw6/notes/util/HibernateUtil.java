package hw6.notes.util;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.util.Locale;

/**
 * Created by jax on 21.06.15.
 */
public class HibernateUtil {
    private static Logger log = Logger.getLogger(HibernateUtil.class);
    private Session session=null;
    public HibernateUtil(){

    }

     public SessionFactory createHiber() {
         Configuration cfg = new Configuration().configure("hw6/hibernate.cfg.xml");
         StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
         sb.applySettings(cfg.getProperties());
         StandardServiceRegistry standardServiceRegistry = sb.build();
         SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
         log.info("Reference to SessionFactory " + factory);
         return factory;
     }
    public void openeSession(SessionFactory factory){
        session=factory.openSession();
    }
     public void sessionClose(){

         session.close();
        }

}
