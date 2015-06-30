package session14;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.03.15
 */
public class MainContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/transactionalContext.xml.xml");
    }
}
