package session14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Sveta on 6/30/2015.
 */

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/context.xml");
        CompanyServiceImpl companyService = context.getBean("service", CompanyServiceImpl.class);
        Company company = new Company("NewEra", 20000);
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        companyService.create(company);
        System.out.println(companyService.findAll());
    }
}
