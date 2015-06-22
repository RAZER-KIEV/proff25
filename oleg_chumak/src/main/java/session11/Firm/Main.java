package session11.Firm;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session10.HiberConnect;

import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by oleg on 22.06.15.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        Company firstC = new Company("c1", new Long(1500));
        Company secondC = new Company("c2", new Long(1500));
        Person perOne = new Person("Vasya");
        Person perTwo = new Person("Petya");
        Person perThree = new Person("Olya");
        Person perFour = new Person("Anya");
        Person perFive = new Person("Lena");
        firstC.addPerson(perOne);
        firstC.addPerson(perTwo);
        secondC.addPerson(perThree);
        secondC.addPerson(perFour);
        secondC.addPerson(perFive);
        perOne.setCompany(firstC);
        perTwo.setCompany(firstC);
        perThree.setCompany(secondC);
        perFour.setCompany(secondC);
        perFive.setCompany(secondC);
        Session session = null;
        session = factory.openSession();
        session.beginTransaction();
        session.save(firstC);
        session.save(secondC);
        session.save(perOne);
        session.save(perTwo);
        session.save(perThree);
        session.save(perFive);
        session.save(perFour);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
