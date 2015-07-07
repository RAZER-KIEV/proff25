package session13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//инжектировние с помощью сеттеров и конструкторов
//класс компании имя и деньги на счету. создать класс директор который работает в компании. создать клссс машина. машина анходится в компании. в машине ездит иректор
/**
 * Created by just1ce on 29.06.2015.
 */
public class Main {
    public static void main(String[] args) {


        ApplicationContext context =
                new ClassPathXmlApplicationContext("session10/context.xml");

        Person pers1 = context.getBean("pers1", Person.class);
        Person pers2 = context.getBean("pers2", Person.class);

        System.out.println(pers1);
        System.out.println(pers2);
    }
}

