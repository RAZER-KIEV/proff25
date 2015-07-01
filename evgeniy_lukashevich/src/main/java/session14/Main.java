package session14;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by Jeckgehor on 30.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/context-anno.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car);
    }
}