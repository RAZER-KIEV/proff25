package session12.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session12.company.dao.CompanyDao;
import session12.company.dao.CompanyDaoImpl;
import session12.company.dao.PersonDao;
import session12.company.dao.PersonDaoImpl;

/**
 * Created by bosyi on 29.06.15.
 */
public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("session12.company/context.xml");
        CompanyDao companyDao = context.getBean("companyDao", CompanyDaoImpl.class);
        PersonDao personDao = context.getBean("personDao", PersonDaoImpl.class);

    }
}
