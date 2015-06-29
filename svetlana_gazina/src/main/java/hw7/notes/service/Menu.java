package hw7.notes.service;

import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.domain.Notebook;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by Sveta on 6/26/2015.
 */
public class Menu {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hw7/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        Notebook notebook = new Notebook();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        notebookDao.create(notebook);

        NotebookServiceImpl notebookService = new NotebookServiceImpl(factory);
        notebookService.getNotebooksGtAmount(0);
    }
}
