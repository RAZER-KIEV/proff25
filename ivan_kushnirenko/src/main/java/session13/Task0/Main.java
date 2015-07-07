package session13.Task0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ivan on 29.06.15.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context.xml");
        //Создаем бины:
        Person pers1 = context.getBean("pers1", Person.class);
        Person pers2 = context.getBean("pers2", Person.class);
        Person pers3 = context.getBean("pers3", Person.class);
        System.out.println(pers1);
        System.out.println(pers2);
        System.out.println(pers3);
    }
}
