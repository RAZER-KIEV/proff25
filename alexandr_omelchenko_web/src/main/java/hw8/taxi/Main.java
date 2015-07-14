package hw8.taxi;

import hw8.taxi.service.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Date;
import java.util.Locale;

/**
 * Created by HP on 12.07.2015.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("hw8/taxi/context.xml");

        ClientService service = context.getBean("clientServiceImpl", ClientService.class);
service.createClient("Alexandr", "Omelchenko", "0931874501","Bilogorodka", 100.00, new Date());
 //       System.out.println(service.getClient(1L));
    }
}