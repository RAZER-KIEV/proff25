package session12.company.view;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session12.company.domain.Company;
import session12.company.domain.Person;
import session12.company.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
 * Created on 22.06.15.
 */
public class Menu {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Collection<Company> companies = new ArrayList<>();
        Collection<Person> persons = new ArrayList<>();
        Company company1 = new Company("Google");
        companies.add(company1);
        Company company2 = new Company("Microsoft");
        companies.add(company2);
        Person per1 = new Person("Ann");
        persons.add(per1);
        Person per2 = new Person("Bogdan");
        persons.add(per2);
        Person per3 = new Person("Dmitry");
        persons.add(per3);
        Person per4 = new Person("Olga");
        persons.add(per4);
        Person per5 = new Person("Emma");
        persons.add(per5);
        company1.hire(per1);
        company1.hire(per2);
        company1.hire(per3);
        company2.hire(per4);
        company2.hire(per5);

        /*System.out.println(company1);
        System.out.println(company2);

        for(Company c:companies) {
            Set<Person> pers = c.getPersons();
            for (Person p:pers) {
                System.out.println(p);
            }
        }*/
        Session session = factory.openSession();
        session.beginTransaction();
        for(Company company:companies) {
            session.save(company);
        }
//        session.getTransaction().commit();
//        session.beginTransaction();
        /*for(Person person:persons) {
            session.save(person);
        }*/
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
