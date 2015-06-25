package week6_lesson11.view;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import week6_lesson11.dao.CompanyDaoImpl;
import week6_lesson11.dao.EmployeeDaoImpl;
import week6_lesson11.domain.Company;
import week6_lesson11.domain.Employee;
import week6_lesson11.util.HiberUtil;

/**
 * Created by HP on 22.06.2015.
 */
public class MainCreator {

    public static void main(String[] args) {
        HiberUtil hiberUtil =new HiberUtil();
        CompanyDaoImpl compDao = new CompanyDaoImpl(hiberUtil.initialize());
        EmployeeDaoImpl emplDao = new EmployeeDaoImpl(hiberUtil.initialize());

 //  Company comp1  =new Company("Epam", 500000.);
//    Company comp2  =new Company("Cola", 10000000.);
 //       Company comp3  =new Company("Apple", 200000000.);
        Employee empl6=new Employee("Melnikov");
  /*  Employee empl1=new Employee("Ivanov");
    Employee empl2=new Employee("Petrov");
    Employee empl3=new Employee("Sidorov");
    Employee empl4=new Employee("Omelchenko");
    Employee empl5=new Employee("Vasylenko");

        empl1.setCompany(comp1);
        empl2.setCompany(comp1);
        empl3.setCompany(comp1);
        empl4.setCompany(comp2);
        empl5.setCompany(comp2);
        comp1.addEmployee(empl1);
        comp1.addEmployee(empl2);
        comp1.addEmployee(empl3);
        comp2.addEmployee(empl4);
        comp2.addEmployee(empl5);
       compDao.create(comp1);
        compDao.create(comp2);*/
      //  compDao.create(comp3);
        emplDao.create(empl6);

        compDao.factoryClose();
        emplDao.factoryClose();
    }
/*
        mainCommands.initialize();
        Session session = mainCommands.factory.openSession();
        try {
            session.beginTransaction();
            Company co = (Company) session.get(Company.class, 26L);
            Company com = (Company) session.get(Company.class, 27L);
            Employee e1 = (Employee) session.get(Employee.class, 28L);
            Employee e2 = (Employee) session.get(Employee.class, 29L);
            Employee e3 = (Employee) session.get(Employee.class, 30L);
            Employee e4 = (Employee) session.get(Employee.class, 31L);
            Employee e5 = (Employee) session.get(Employee.class, 32L);
            session.delete(co);
            session.delete(com);
            session.delete(e1);
            session.delete(e2);
            session.delete(e3);
            session.delete(e4);
            session.delete(e5);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        mainCommands.factoryClose();
    }*/

}