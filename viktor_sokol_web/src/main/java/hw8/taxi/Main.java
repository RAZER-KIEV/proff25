package hw8.taxi;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Main {
    public static void main(String[] args) throws OrderException {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("22 |adsads|qwwqqw".split(" ")[0]);
//        ApplicationContext context = new ClassPathXmlApplicationContext("hw8/context.xml");
//        AuthenticationService authenticationService = context.getBean("authenticationServiceImpl",AuthenticationService.class);
//        ClientService clientService = context.getBean("clientServiceImpl",ClientService.class);
//        for(Object client:clientService.showClientsLastMonth()){
//            System.out.println(client);
//        }
//        ClientService clientService = context.getBean("clientServiceImpl",ClientService.class);
//        OrderService orderService = context.getBean("orderServiceImpl",OrderService.class);
//        orderService.createOrder(1L,clientService.getClient(1L),"222","fromAddress","toAddress");
//
//        System.out.println(authenticationService.getCountAttempts());
//        authenticationService.createOperator(new Operator("Adm","1"));
//        System.out.println(authenticationService.getOperator(1L));
//        System.out.println(authenticationService.getOperator(3L));
//        System.out.println(authenticationService.authenticate("Operator1", "11"));
    }
}
