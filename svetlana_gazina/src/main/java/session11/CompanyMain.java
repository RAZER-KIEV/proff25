package session11;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Sveta on 6/22/2015.
 */
public class CompanyMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
//        Session session = factory.openSession();
//
//        Company companyFirst = new Company("First", new HashSet<>());
//        Company companySecond = new Company("Second", new HashSet<>());
//
//        Employee emp1 = new Employee("fist");
//        Employee emp2 = new Employee("Second");
//        Employee emp3 = new Employee("Third");
//        Employee emp4 = new Employee("Fourth");
//        Employee emp5 = new Employee("Fifth");
//
//        Set<Employee> employees1 = companyFirst.getEmployees();
//        Set<Employee> employees2 = companySecond.getEmployees();
//
//
//        employees1.add(emp1);
//        employees1.add(emp2);
//        employees1.add(emp3);
//        emp1.setCompany(companyFirst);
//        emp2.setCompany(companyFirst);
//        emp3.setCompany(companyFirst);
//
//
//        employees2.add(emp4);
//        employees2.add(emp5);
//        emp4.setCompany(companySecond);
//        emp5.setCompany(companySecond);
//
//        try {
//            session.beginTransaction();
//            session.save(companyFirst);
//            session.save(companySecond);
//            session.save(emp1);
//            session.save(emp2);
//            session.save(emp3);
//            session.save(emp4);
//            session.save(emp5);
//            session.getTransaction().commit();
//
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            session.getTransaction().rollback();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//            if (factory != null) {
//                factory.close();
//            }
//        }
//        CompanyService companyService = new CompanyServiceImpl(session, factory);
//        System.out.println("        RESULT1: ");
//        Employee employee = (Employee)companyService.getEmpFromCompany("First").get(0)[1];
//        System.out.println(employee.getName());
//        System.out.println(companyService.getEmpFromCompany("First").get(0)[1].getClass());
//        System.out.println("        RESULT2: ");
//        System.out.println(companyService.getEmpFromAllCompanies().get(0)[1].getClass());

        CompanyDaoImpl companyDao = new CompanyDaoImpl(factory);
        System.out.println(companyDao.CompaniesWithMoThanEmp((long)2));



        factory.close();


    }


}
