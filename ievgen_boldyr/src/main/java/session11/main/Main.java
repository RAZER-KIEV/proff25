package session11.main;

import session11.util.HibernateUtil;
import session11.dao.CompanyDaoImpl;
import session11.dao.EmployeeDaoImpl;
import session11.domain.Company;

/**
 * Created by nucleos on 13.12.14.
 */

public class Main {
    public static void main(String[] args) {
        CompanyDaoImpl companyDao = new CompanyDaoImpl();
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
/*        Company company1 = new Company("Comp1", 10000.0);
        Company company2 = new Company("Comp2", 15000.0);

        Employee employee1 = new Employee("Employee1", "no exp", 1000.0, company1);
        Employee employee2 = new Employee("Employee2", "no exp", 1000.0, company2);
        Employee employee3 = new Employee("Employee3", "no exp", 1000.0, company1);
        Employee employee4 = new Employee("Employee4", "no exp", 1000.0, company2);
        Employee employee5 = new Employee("Employee5", "no exp", 1000.0, company1);

        companyDao.create(company1);
        companyDao.create(company2);

        employeeDao.create(employee1);
        employeeDao.create(employee2);
        employeeDao.create(employee3);
        employeeDao.create(employee4);
        employeeDao.create(employee5);*/

        Company company = companyDao.read(new Long(39));
        //List<Employee> result = companyDao.employees(company.getCompany());

        Double obj = companyDao.employeesBySalary(new Double(1000.0));
        System.out.println(obj.toString());
        HibernateUtil.getSessionFactory().close();

        /*for (Employee employee : result) {
            System.out.println(employee.toString());
        }*/


    }
}
