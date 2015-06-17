package hw6.notes.service;


import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;

import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

public class Menu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.createSessionFactory();

        NotebookServiceImpl notebookService = new NotebookServiceImpl(hibernateUtil.getFactory());
        Notebook notebook = new Notebook("OA-PQ-09","ASER","ASPIRE",new Date(Calendar.getInstance().getTimeInMillis()),40000.);

        System.out.println(notebookService.add(notebook));

        for (Notebook notebook1:notebookService.findAll())
            notebook1.print();

        hibernateUtil.closeFactory();
    }
}
