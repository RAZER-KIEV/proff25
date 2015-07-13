package session13.Task1.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session13.Task1.domain.Car;
import session13.Task1.domain.Company;

/**
 * Created by ivan on 29.06.15.
 */

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context-anno.xml");
//        Company company = context.getBean("company",Company.class);
//        Car car = company.getCar();
//        System.out.println(company);
//        System.out.println(car);
        Car car = context.getBean("car",Car.class);
        System.out.println(car);
    }
}
