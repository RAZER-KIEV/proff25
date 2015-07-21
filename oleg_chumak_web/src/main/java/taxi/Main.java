package taxi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import taxi.domain.Operator;
import taxi.service.TService;
import taxi.service.TServiceImpl;

/**
 * Created by oleg on 21.07.15.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/dataContext.xml");
        TService service = context.getBean("TServiceImpl", TServiceImpl.class);
        System.out.println(service.readRole("User"));
//        service.createOperator(new Operator())
    }
}
