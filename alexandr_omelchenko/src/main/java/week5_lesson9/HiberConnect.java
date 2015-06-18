package week5_lesson9;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import javax.persistence.*;
import java.util.List;
import java.util.Locale;
@Entity
public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();

            session.beginTransaction();
           // Long id =(Long)session.save(new Region("Antarktida"));
         //   session.createSQLQuery("UPDATE regions SET REGION_NAME='Antarktika' WHERE REGION_NAME='Antarktida' ");
            List<Region> regionList = session.createSQLQuery("SELECT * FROM REGIONS WHERE REGION_NAME='Antarktida' and REGION_ID=19").addEntity(Region.class).list();
            for(Region reg:regionList) {
               // reg.setName("Antarktida");
             //   session.update(reg);
                session.delete(reg);
                  }

                     session.getTransaction().commit();
           // Region region =(Region)session.get(Region.class, 5L);
          //  System.out.println(region.toString());
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();}
        }
        log.info(session);
        factory.close();
    }
}