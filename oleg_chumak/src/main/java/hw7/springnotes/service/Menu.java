package hw7.springnotes.service;

import hw7.springnotes.domain.Vendor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by oleg on 24.06.15.
 */
public class Menu {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("hw7/context_db.xml");
        NotebookServiceImpl service = context.getBean("notebookServiceImpl", NotebookServiceImpl.class);
        service.strartDao();
//        System.out.println(service.notebookDao.read(9L));
//        System.out.println(service.notebookDao.findAll());
        System.out.println(service.createVendor(new Vendor("fff")));
    }
}
