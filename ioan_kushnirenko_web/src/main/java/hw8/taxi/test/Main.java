package hw8.taxi.test;

import hw8.taxi.service.TaxiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Locale;

/**
 * Created by ivan on 15.07.15.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("ioan_kushnirenko_web/src/main/webapp/WEB-INF/spring/dataContext.xml");
        TaxiService service = context.getBean("taxiServiceImpl",TaxiService.class);
        List list = service.showAll();
        System.out.println(list.toString());

    }

}
