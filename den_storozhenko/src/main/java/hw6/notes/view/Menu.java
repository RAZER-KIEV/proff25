package hw6.notes.view;


import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

public class Menu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hw6/dao.notebook.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        NotebookServiceImpl notebookService = new NotebookServiceImpl(factory);
        Notebook notebook = new Notebook("OA-PQ-09","ASER","ASPIRE",new Date(Calendar.getInstance().getTimeInMillis()),40000.);

        System.out.println(notebookService.add(notebook));

        for (Notebook notebook1:notebookService.findAll())
            notebook1.print();

        factory.close();
    }
}
