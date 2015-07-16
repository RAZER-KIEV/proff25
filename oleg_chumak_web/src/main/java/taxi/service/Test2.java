package taxi.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import taxi.domain.TaxiDriver;

import java.util.Locale;

/**
 * Created by HP on 16.07.2015.
 */
public class Test2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("dataContext.xml");

        Service service = context.getBean("serviceImpl", Service.class);
        //    service.createOperator()
        service.createTaxist(new TaxiDriver("Balvan", "Mercedes", "AA0001AA", "0939393933"));

    }
}
