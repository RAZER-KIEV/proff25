package week7_lesson13.Task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week7_lesson13.Person;

/**
 * Created by HP on 29.06.2015.
 */
public class Main {
    public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext("session13/contextDirector.xml");
    Company comp = context.getBean("firm", Company.class);
    Director dir = context.getBean("dir", Director.class);
    Car car = context.getBean("car", Car.class);

    System.out.println(comp);
    System.out.println(dir);
    System.out.println(car);
}
}