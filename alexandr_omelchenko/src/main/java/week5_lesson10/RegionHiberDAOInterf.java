package week5_lesson10;

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

        RegionHiberDAOInterf dao = new RegionHiberDAOInterf();
        dao.initialize();
        dao.openSession();
        dao.beginTransaction();
        //dao.read(3L);

        dao.delete(21L);
      // System.out.println(dao.read(3L).toString());
dao.commit();
        dao.closeSession();
        dao.factory.close();
      //  Long f = Long.valueOf(2);
      //  Long l = Long.valueOf(4);
      //  List list =dao.findDiapazon(f, l);
      //  System.out.println(list.toString());

       // Region region =(Region) session.get(Region.class, 1);
     //   dao.update(region);
    }

    private SessionFactory factory;
    private Session session;
    private static Logger log = Logger.getLogger(RegionHiberDAOInterf.class);

    public RegionHiberDAOInterf(SessionFactory factory) {
        this.factory = factory;
    }
    public RegionHiberDAOInterf() {
    }

    //МЕТОДЫ
    @Override
   public void initialize(){
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
    }
    @Override
 public void openSession(){
    if ((session = factory.openSession())==null)
        throw  new HibernateException("Session does not created!");
}
    @Override
    public void closeSession(){
        if (session!=null) {
            session.close();}
        log.info(session);
    }
    @Override
    public void beginTransaction(){
        session.beginTransaction();
    }
    @Override
    public void commit(){
        session.getTransaction().commit();
    }
    @Override
    public Long create(Region region) {
        Long id = null;
        try {
            id = (Long) session.save(region);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return id;
    }

    @Override
    public Region read(Long id) {
        try {
            return (Region) session.get(Region.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }
    @Override
    public Long update(Region region) {
        try{
            session.update(region);
            session.getTransaction().commit();
        }
     catch (HibernateException e) {
        log.error("Transaction failed");
        session.getTransaction().rollback();
    } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    @Override
    public Long delete(Region region) {
session.delete(region);
        return null;
    }
    @Override
    public Long delete(Long id) {
        Region reg =(Region)session.get(Region.class,id);
        session.delete(reg);
        return null;
    }

    @Override
    public List<Region> findAll() {
        try {
            List<Region> list = session.createQuery("from week5_lesson9.Region").list();
            return list;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session!=null)
                session.close();
        }
        return null;
    }

    @Override
    public List<Region> findHonyGT(Long amount) {
        List<Region> rezlist=new ArrayList<>();
            try {
                List<Region> list = session.createQuery("from week5_lesson9.Region").list();
                for(Region reg: list){if(reg.getId()==amount) rezlist.add(reg);}
                return rezlist;
            } catch (HibernateException e) {
                log.error("Transaction failed");
                session.getTransaction().rollback();
            } finally {
                if (session!=null)
                    session.close();
            }
            return null;                       }
    @Override
    public List<Region> findDiapazon(Long amount, Long last) {
        List<Region> rezlist=new ArrayList<>();
        try {
            List<Region> list = session.createQuery("from week5_lesson9.Region").list();
            for(Region reg: list){if(reg.getId()>=amount&&reg.getId()<=last) rezlist.add(reg);}
            return rezlist;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session!=null)
                session.close();
        }
        return null;                                         }
    @Override //Вывести имена всех регионов порциями по 2 штуки
    public void printBy(int kol, int start){
        try{
            session.beginTransaction();
         //   Query query = (Query) session.createQuery("Select c.name from REGIONS c ");
         //   query.setFirstRezult();
         //   query.setMaxRezult();

        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session!=null)
                session.close();
        }
    }
    }