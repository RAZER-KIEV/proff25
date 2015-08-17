package session14;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 30.06.15
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/context-anno.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car);


        // comment for branch1
        // comment for branch2
    }
}
