package lection06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by storo_000 on 22.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.createSessionFactory();
        SessionFactory sessionFactory = hibernateUtil.getFactory();

        Person person1 = new Person("Ivanov");
        Person person2 = new Person("Petrov");
        Person person3 = new Person("Sidorov");
        Person person4 = new Person("Vasiliev");
        Person person5 = new Person("Pupkin");

        Company company1 = new Company("Company1", 12304);
        Company company2 = new Company("Company2", 59123);

        Session session = sessionFactory.openSession();

        /*session.beginTransaction();
        List<Company> companies = session.createQuery("from Company").list();
        for (Company company:companies){
            session.delete(company);
        }
        List<Person> persons = session.createQuery("from Person").list();
        for (Person person:persons){
            session.delete(person);
        }
        session.getTransaction().commit();*/

        session.beginTransaction();
        session.save(person1);
        session.save(person2);
        session.save(person3);
        session.save(person4);
        session.save(person5);
        session.save(company1);
        session.save(company2);
        session.getTransaction().commit();

        person1.setCompany(company2);
        person2.setCompany(company1);
        person3.setCompany(company1);
        person4.setCompany(company2);
        person5.setCompany(company1);

        Set<Person> personSet1 = new HashSet<>();
        personSet1.add(person2);
        personSet1.add(person3);
        personSet1.add(person5);

        Set<Person> personSet2 = new HashSet<>();
        personSet2.add(person1);
        personSet2.add(person4);
        company2.setPersons(personSet2);

        company1.setPersons(personSet1);
        company2.setPersons(personSet2);

        session.beginTransaction();
        session.update(person1);
        session.update(person2);
        session.update(person3);
        session.update(person4);
        session.update(person5);
        session.update(company1);
        session.update(company2);
        session.getTransaction().commit();

        hibernateUtil.closeFactory();
    }

}
