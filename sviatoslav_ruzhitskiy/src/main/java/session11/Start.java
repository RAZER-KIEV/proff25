package session11;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by RAZER on 22.06.2015.
 */
public class Start {
    private static Logger log = Logger.getLogger(Start.class);
    SessionFactory sessionFactory;
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + sessionFactory);




        Company company1 = new Company("UltraComp",Double.parseDouble("2324414214"));
        Company company2 = new Company("MegaComp", Double.parseDouble("1231245125"));

        Emploee emp1 = new Emploee("Uasia",company1);
        Emploee emp2 = new Emploee("Petia", company1);
        Emploee emp3= new Emploee("Ualera", company2);
        Emploee emp4 = new Emploee("Aliosha",company2);
        Emploee emp5 = new Emploee("Siroga", company2);

        company1.addEmploee(emp1);
        company1.addEmploee(emp2);

        company2.addEmploee(emp3);
        company2.addEmploee(emp4);
        company2.addEmploee(emp5);



        Session session = sessionFactory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            session.save(company1);
            session.save(company2);
            session.save(emp1);
            session.save(emp2);
            session.save(emp3);
            session.save(emp4);
            session.save(emp5);
            session.getTransaction().commit();
        }catch (HibernateException hEx){
            System.out.println("Exception: Not saved!");
            log.error("Exception: Not saved!  "+hEx);
            hEx.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }




    }
}
