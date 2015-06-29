package session11.Service;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.domain.Company;
import session11.domain.Employee;

/**
 * Created by ivan on 22.06.15.
 */

public class Test {

    private static SessionFactory factory;

    public static void main(String[] args) {

        Configuration cfg = new Configuration()
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(session11.domain.Employee.class)
                .configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);

        Logger logComp = Logger.getLogger(Company.class);
        Logger logEmpl = Logger.getLogger(Employee.class);

        Company c1 = new Company("SMK",200D);
        Employee e1 = new Employee("Ivan",c1);
        add(c1,logComp);
        add(e1,logEmpl);
    }

    private static void add(Object o,Logger log){
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
        } catch (HibernateException e){
            log.error("Error in adding: "+o);
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }


}
