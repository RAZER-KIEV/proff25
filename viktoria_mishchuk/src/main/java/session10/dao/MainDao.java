package session10.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session10.dao.DaoHibernateRegion;
import session10.HiberConnect;
import session10.Region;

import java.util.Locale;


/**
 * Created by viktoria
 * Project:.session10
 */
public class MainDao {
/*    public static void main(String[] args) {
        SessionFactory factory = null;
        factory.openSession();

      ;*/

    public static void main(String[] args) {
        Logger log = Logger.getLogger(HiberConnect.class);
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

            Region region = (Region) session.get(Region.class , 1L);

            session.beginTransaction();
           DaoHibernateRegion dao = new DaoHibernateRegion(factory);
//            dao.create(new Region("Ukraine"));
            System.out.println(dao.findAll());
            for (int i = 0; i <= 6; i++) {
            dao.RegionPortion(i,2);
                i++;
            }


        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
    }
}



