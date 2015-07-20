package session14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bosyi on 29.06.15.
 */
public class MainForCompany {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("session14/contextCompany.xml");
        Company company = context.getBean("company", Company.class);
        System.out.println(company);
        System.out.println(company.getCar());
        System.out.println(company.getCeo());
    }
}
