package session14;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import week6_lesson11.domain.Employee;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 30.06.15
 */
public class Main {
    public static void main(String[] args) {
     /*   ApplicationContext context = new ClassPathXmlApplicationContext("session14/context-anno.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car);*/
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/context-c-e.xml");
        Employee empl = context.getBean("employee", Employee.class);
        System.out.println(empl.getCompany());
    }
}
