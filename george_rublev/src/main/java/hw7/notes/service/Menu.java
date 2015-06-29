package hw7.notes.service;


import hw7.notes.util.HibernateUtil;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import org.hibernate.SessionFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Menu {
    public static void main(String[] args) throws ParseException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.createSessionFactory();
        SessionFactory sessionFactory = hibernateUtil.getFactory();

        NotebookServiceImpl notebookService = new NotebookServiceImpl(sessionFactory);



        sessionFactory.close();
    }
}
