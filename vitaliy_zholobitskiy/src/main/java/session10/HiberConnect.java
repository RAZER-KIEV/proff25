package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import javax.transaction.Transaction;
import java.util.Locale;
import java.util.Scanner;


public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) throws InterruptedException {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
        RegionHibernateDaoImpl regionHibernateDao=new RegionHibernateDaoImpl(factory);
        System.out.println(regionHibernateDao.getPorcies(2));
        System.out.println(regionHibernateDao.getPorcies(2));
        factory.close();

        //Session session = null;
        //try {
            //session = factory.openSession();

            //Region region = (Region)session.get(Region.class, 1L);


            //session.beginTransaction();

           // Region reg = new Region();
            //reg.setName("Antarktika");
            //session.delete(reg);

            //Long id = (Long)session.save(reg);
           // session.getTransaction().commit();


            //This makes the pending delete to be done


        //} catch (HibernateException e) {
            //log.error("Open session failed", e);
            //session.getTransaction().rollback();
       // } finally {
           // if (session != null) {
              //  session.close();
           // }
       // }
        //log.info(session);
        //factory.close();
    }
}
