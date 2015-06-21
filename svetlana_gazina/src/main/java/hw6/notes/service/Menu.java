package hw6.notes.service;

import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Sveta on 6/21/2015.
 */
public class Menu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        NotebookServiceImpl ndService = new NotebookServiceImpl(factory);
        Notebook notebook = new Notebook(new BigDecimal(12400), "ASUS", "ASP348567", "Slim", new Date(12-10-2014));
        ndService.add(notebook);

    }
}
