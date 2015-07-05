package session13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sveta on 6/29/2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context.xml");
        Person pers1 = context.getBean("pers1", Person.class);
        Person pers2 = context.getBean("pers2", Person.class);
        System.out.println(pers1);
        System.out.println(pers2.toString());
//        Company company = context.getBean("comp", Company.class);
//        System.out.println(company);

    }
}
