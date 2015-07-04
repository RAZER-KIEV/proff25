package hw7.springnotes.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by oleg on 24.06.15.
 */
public class Menu {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("hw7/context_db.xml");
        NotebookServiceImpl service = context.getBean("notebookServiceImpl", NotebookServiceImpl.class);
        service.strartDao();
//        System.out.println(service.getSalesByDays());
        System.out.println(service.notebookDao.findAll());
    }
}
