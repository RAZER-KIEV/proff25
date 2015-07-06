package session12.service;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import scala.Char;
import session12.dao.CompanyDaoImpl;
import session12.domain.Company;
import session12.domain.Person;

import java.util.*;

import org.springframework.stereotype.*;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

/**
 * Created by just1ce on 30.06.2015.
 */
@Transactional
@Component
public class Service {
    private ApplicationContext context =
            new ClassPathXmlApplicationContext("session14/context-anno.xml");
    @Autowired
    private CompanyDaoImpl companyDaoImpl;// = context.getBean("companyDaoImpl",CompanyDaoImpl.class);// new CompanyDaoImpl(context.getBean("sf", SessionFactory.class));
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public void work(){
        Locale.setDefault(Locale.ENGLISH);
        System.out.println(companyDaoImpl.getCompaniesByCountEmpl(1));
        Scanner in = new Scanner(System.in);
        System.out.println("1 - get employees from company you entered;");
        System.out.println("2 - get all employees from all companies;");
        System.out.println("Enter:");
        String k = in.nextLine();
        if (k.equals("1")) {
            System.out.println("Enter name of company:");
            String s = in.nextLine();
            List<Person> comp = companyDaoImpl.findEmpFromCompany(s);
            for (Person p : comp) {
                System.out.println(p.getName());
            }
        } else {
            List<Person> comp = companyDaoImpl.getAll();
            for (Person p : comp) {
                System.out.println(p.getName());
            }
           String s="s";

        }
    }
}
//приложение сконм меню в которм пользователь вводит мя компании. вывексти всех сотрудников работающих в этой компании