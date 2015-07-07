package session14.view;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by ivan on 30.06.15.
 */
public class MainContext {
    ApplicationContext context = new ClassPathXmlApplicationContext("session14/transactionalContext.xml");

    public static void main(String[] args) {
        System.out.println(new MainContext().context);
    }

}
