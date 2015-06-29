package session12.view;


import session12.dao.CompanyDaoImpl;
import session12.domain.Person;
import session12.util.HibernateUtil;
import java.util.*;
import java.util.List;

/**
 * Created by just1ce on 23.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        HibernateUtil util = new HibernateUtil();
        util.createSessionFactory();
        CompanyDaoImpl companyDao = new CompanyDaoImpl(util.getFactory());
        System.out.println(companyDao.getCompaniesByCountEmpl(1));
        Scanner in = new Scanner(System.in);
        System.out.println("1 - get employees from company you entered;");
        System.out.println("2 - get all employees from all companies;");
        System.out.println("Enter:");
        String k = in.nextLine();
        if (k.equals("1")) {
            System.out.println("Enter name of company:");
            String s = in.nextLine();
            List<Person> comp = companyDao.findEmpFromCompany(s);
            for (Person p : comp) {
                System.out.println(p.getName());
            }
        } else {
            List<Person> comp = companyDao.getAll();
            for (Person p : comp) {
                System.out.println(p.getName());
            }
        }


    }
}
