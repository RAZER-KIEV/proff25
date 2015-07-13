package session13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class Main {
    public static void main (String [] args) {
       /* ApplicationContext context = new ClassPathXmlApplicationContext("session13/context.xml");
        Person pers1 = context.getBean("pers1", Person.class);
        Person pers2 = context.getBean("pers2", Person.class);
        System.out.println(pers1);
        System.out.println(pers2); */

        ApplicationContext context = new ClassPathXmlApplicationContext("session13/contextCompany.xml");
        Director director = context.getBean("dir", Director.class);
        Car car = context.getBean("machine", Car.class);
        Company company = context.getBean("company", Company.class);

        System.out.println(director);
        System.out.println(car);
        System.out.println(company);
    }
}
