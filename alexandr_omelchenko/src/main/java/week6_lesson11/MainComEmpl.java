package week6_lesson11;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by HP on 22.06.2015.
 */
public class MainComEmpl {
    private SessionFactory factory;
    public SessionFactory initialize(){
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
        return factory;
    }
    public void factoryClose(){
        factory.close();
    }

    public static void main(String[] args) {

MainComEmpl mainCommands = new MainComEmpl();
   Company comp1  =new Company("Epam", 500000.);
    Company comp2  =new Company("Cola", 10000000.);
    Emploee empl1=new Emploee();
    Emploee empl2=new Emploee();
    Emploee empl3=new Emploee();
    Emploee empl4=new Emploee();
    Emploee empl5=new Emploee();

        empl1.setCompany(comp1);
        empl2.setCompany(comp1);
        empl3.setCompany(comp1);
        empl4.setCompany(comp2);
        empl5.setCompany(comp2);

        comp1.addEmploee(empl1);
        comp1.addEmploee(empl2);
        comp1.addEmploee(empl3);
        comp2.addEmploee(empl4);
        comp2.addEmploee(empl5);
        mainCommands.initialize();
        Session session = mainCommands.factory.openSession();
        try {
            session.beginTransaction();
            session.save(comp1);
            session.save(comp2);
            session.save(empl1);
            session.save(empl2);
            session.save(empl3);
            session.save(empl4);
            session.save(empl5);

            session.getTransaction().commit();
        }catch (HibernateException e){
            session.getTransaction().rollback();
        }finally {
            if (session!=null)
                session.close();
        }
        mainCommands.factoryClose();
    }
}