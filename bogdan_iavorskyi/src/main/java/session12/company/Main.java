package session12.company;

import org.hibernate.SessionFactory;
import session12.company.domain.Company;
import session12.company.domain.Person;
import session12.company.service.PersonService;
import session12.company.service.PersonServiceImpl;
import session12.company.util.HibernateUtil;

import java.util.List;

/**
 * Created by bosyi on 23.06.15.
 */
public class Main {
    public static void main(String[] args) {
        /*SessionFactory factory = HibernateUtil.getSessionFactory();
//        PersonService personService = new PersonServiceImpl();
//        List listOfArrays = personService.listByCompany("Google");
        List listOfArrays = personService.listCompaniesHireMoreThanXEmployees(1);
        for (int i = 0; i < listOfArrays.size(); i++) {
            Object[] array = (Object[]) listOfArrays.get(i);
            String name = (String) array[0];
            System.out.println(name);
        }

        *//*List<Person> persons = personService.listAll();
        for(Person person:persons) {
            System.out.println(person.getName());
        }*//*

        *//*List<Company> companies = personService.listCompaniesHireMoreThanXEmployees(2);
        for (Company company:companies) {
            System.out.println(company.getName());
        }*//*

        factory.close();*/
    }
}
