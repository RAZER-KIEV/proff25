package session13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session13.Com.Company;

/**
 * Created by oleg on 29.06.15.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Person pers1 = context.getBean("pers1", Person.class);
        Person pers2 = context.getBean("pers2", Person.class);
        System.out.println(pers1);
        System.out.println(pers2);
        Company company = context.getBean("company", Company.class);
        System.out.println(company);
    }
}
