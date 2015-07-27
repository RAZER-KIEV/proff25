package session11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.dao.CompanyDaoImpl;
import session11.dao.EmployeeDaoImpl;
import session11.domain.Company;
import session11.domain.Employee;

import java.util.List;
import java.util.Locale;

/**
 * Created by viktoria
 * Project:.session11
 */
public class MainCompany {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        CompanyDaoImpl companyDao = new CompanyDaoImpl(factory);
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(factory);


        Employee empl1 = new Employee("Steven");
        Employee empl2 = new Employee("Maven");
        Company apple = new Company("Apple", 100000000000.00);
        apple.getJob(empl1);
        apple.getJob(empl2);
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(apple);
//        session.save(empl1);
        session.getTransaction().commit();

//        companyDao.findAll();
        employeeDao.createEmployee(empl1);
        employeeDao.createEmployee(empl2);
//        System.out.println( companyDao.findEmpl(apple));
//        System.out.println(employeeDao.findEmpl(apple));

        System.out.println(employeeDao.findAll());

//        List<Object[]> emplInCompany = (Object)employeeDao.findEmpl(apple);

        }
    }

