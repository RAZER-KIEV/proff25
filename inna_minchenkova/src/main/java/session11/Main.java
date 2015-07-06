package session11;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by Inna on 22.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);

        CompanyDao companyDao = new CompanyDaoImpl(sessionFactory);
        EmployeeDao employeeDao = new EmployeeDaoImpl(sessionFactory);

        Company company = new Company();
        company.setName("Apple");
        companyDao.create(company);

        Company company1 = new Company("Google");
        companyDao.create(company1);

        Employee employee = new Employee("Petrov");
        employeeDao.create(employee);
        Employee employee1 = new Employee("Ivanov");
        employeeDao.create(employee1);







    }
}
