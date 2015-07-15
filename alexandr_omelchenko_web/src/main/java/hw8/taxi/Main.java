package hw8.taxi;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.OperatorService;
import hw8.taxi.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Date;
import java.util.Locale;

/**
 * Created by HP on 12.07.2015.
 */
public class Main {
    public static void main(String[] args) throws OrderException {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("hw8/taxi/context.xml");

 /*       ClientService clService = context.getBean("clientServiceImpl", ClientService.class);
        clService.createClient("Ivan", "Ivanov", "0955464501","Kyiv", 300.00, new Date());

        OrderService ordService = context.getBean("orderServiceImpl", OrderService.class);
        Client cl =clService.getClient(4L);
        ordService.createOrder(50.00, "Revytskogo,8", "Petrova, 2", new Date(), cl);

        OperatorService operService = context.getBean("operatorServiceImpl", OperatorService.class);
        operService.createOperator("0000000003","karas","kl4942Ag",new Date(), new Date(), 0, false );*/
        AuthenticationService authService = context.getBean("authenticationServiceImpl", AuthenticationService.class);
   System.out.print(authService.authorization("mer", "a44n73"));
    }
}