package hw7.springnotes;

import hw7.springnotes.service.NotebookService;
import hw7.springnotes.view.Menu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("hw7\\springnotes\\context.xml");
        NotebookService companyService = context.getBean("notebookServiceImpl", NotebookService.class);
        Menu menu = new Menu(companyService);
        menu.start();
    }
}
