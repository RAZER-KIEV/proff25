package session13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by viktoria
 * Project:.session13
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context.xml");

        Person pers1 = context.getBean("pers1", Person.class);
        Person pers2 = context.getBean("pers2", Person.class);

        Company company = context.getBean("apple", Company.class);
        Director director = context.getBean("director", Director.class);
        Car car = context.getBean("car", Car.class);

        System.out.println(pers1);
        System.out.println(pers2);

        System.out.println(company.toString());
    }
}
