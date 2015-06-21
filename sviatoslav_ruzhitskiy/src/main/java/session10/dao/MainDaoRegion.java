package session10.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session10.Region;
import org.apache.log4j.Logger;

import java.util.Locale;

/**
 * Created by RAZER on 16.06.2015.
 */
public class MainDaoRegion {
      public static void main(String[] args) {
          Locale.setDefault(Locale.ENGLISH);
       org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MainDaoRegion.class);

        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

          Region region = new Region("Antarctica");

          RegionHipernateDaoImpl regionHipernateDao = new RegionHipernateDaoImpl(factory);
          regionHipernateDao.create(region);


    }
}