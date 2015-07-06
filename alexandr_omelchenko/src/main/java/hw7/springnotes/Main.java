package hw7.springnotes;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.Vendor;
import hw7.springnotes.service.NotebookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by HP on 04.07.2015.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("hw7/springnotes/context.xml");

        NotebookService service = context.getBean("notebookServiceImpl", NotebookService.class);
        System.out.println(service.getNotebooksStorePresent());
    }
}
