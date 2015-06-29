package session11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.*;

/**
 * Created by Jeckgehor on 22.06.2015.
 */
public class CompanyEmployeeMain {

    public static void main (String[] args){

        Company company1 = new Company("Apple", 2520.58);
        Company company2 = new Company("Toshiba", 5485.58);

        Employee employee1 = new Employee("Jon");
        Employee employee2 = new Employee("Berta");
        Employee employee3 = new Employee("Pol");
        Employee employee4 = new Employee("Den");
        Employee employee5 = new Employee("Oscar");

        Set<Employee> set1 = new HashSet<>();
        set1.add(employee1);
        set1.add(employee2);
        Set<Employee> set2 = new HashSet<>();
        set2.add(employee3);
        set2.add(employee4);
        set2.add(employee5);

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
        ssrb.applySettings(cfg.getProperties());
        StandardServiceRegistry ssr = ssrb.build();
        SessionFactory factory = cfg.buildSessionFactory(ssr);
        Session session = factory.openSession();

        company1.setEmployee(set1);
        company2.setEmployee(set2);
        employee1.setCompany(company1);
        employee2.setCompany(company1);
        employee3.setCompany(company2);
        employee4.setCompany(company2);
        employee5.setCompany(company2);

        session.beginTransaction();
        session.save(company1);
        session.save(company2);
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
        session.save(employee5);
        session.getTransaction().commit();

        session.close();
        factory.close();

    }
}
