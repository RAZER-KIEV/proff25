package week_lesson10;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.apache.log4j.Logger;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import week5_lesson9.Region;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by HP on 16.06.2015.
 */
public class RegionHiberDAOInterf implements RegionDao {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        RegionHiberDAOInterf dao = new RegionHiberDAOInterf(factory);
        Long f = Long.valueOf(2);
        Long l = Long.valueOf(4);
        List list =dao.findDiapazon(f, l);
        System.out.println(list.toString());
    }

    private static Logger log = Logger.getLogger(RegionHiberDAOInterf.class);
    private SessionFactory factory;

    public RegionHiberDAOInterf(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Region region) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(region);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (factory != null)
                factory.close();
        }
        return id;
    }

    @Override
    public Region read(Region region) {
        Session session = factory.openSession();
        try {
            return (Region) session.get(Region.class, 1L);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Long update(Region region) {
        return null;
    }

    @Override
    public Long delete(Region region) {
        return null;
    }

    @Override
    public List<Region> findAll() {
        Session session = factory.openSession();
        try {
            List<Region> list = session.createQuery("from week5_lesson9.Region").list();
            return list;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
            if (factory != null)
                factory.close();
        }
        return null;
    }

    @Override
    public List<Region> findHonyGT(Long amount) {
        Session session = factory.openSession();
        List<Region> rezlist=new ArrayList<>();
            try {
                List<Region> list = session.createQuery("from week5_lesson9.Region").list();
                for(Region reg: list){if(reg.getId()==amount) rezlist.add(reg);}
                return rezlist;
            } catch (HibernateException e) {
                log.error("Transaction failed");
                session.getTransaction().rollback();
            } finally {
                session.close();
                if (factory != null)
                    factory.close();
            }
            return null;                       }
    @Override
    public List<Region> findDiapazon(Long amount, Long last) {
        Session session = factory.openSession();
        List<Region> rezlist=new ArrayList<>();
        try {
            session.beginTransaction();
            List<Region> list = session.createQuery("from week5_lesson9.Region").list();
            for(Region reg: list){if(reg.getId()>=amount&&reg.getId()<=last) rezlist.add(reg);}
            return rezlist;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
            if (factory != null)
                factory.close();
        }
        return null;                                         }
    @Override //Вывести имена всех регионов порциями по 2 штуки
    public void printBy(int kol, int start){
        Session session = factory.openSession();
        try{
            session.beginTransaction();
         //   Query query = (Query) session.createQuery("Select c.name from REGIONS c ");
         //   query.setFirstRezult();
         //   query.setMaxRezult();

        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
            if (factory != null)
                factory.close();
        }
    }
    }