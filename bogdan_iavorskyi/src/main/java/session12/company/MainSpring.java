package session12.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session12.company.dao.CompanyDao;
import session12.company.dao.CompanyDaoImpl;
import session12.company.dao.PersonDao;
import session12.company.dao.PersonDaoImpl;
import session12.company.domain.Company;
import session12.company.domain.Person;
import session12.company.service.PersonService;
import session12.company.service.PersonServiceImpl;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by bosyi on 29.06.15.
 */
public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("session12.company/context.xml");
        PersonService service = context.getBean("service", PersonServiceImpl.class);
        List<Person> companies = service.listAll();
        companies.forEach(person -> System.out.println(person.getName()));

    }
}
