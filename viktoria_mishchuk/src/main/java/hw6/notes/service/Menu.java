package hw6.notes.service;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;

import java.util.Date;
import java.util.Locale;

/**
 * Created by viktoria
 * Project:.hw6.notes.service
 *
 */
public class Menu {

    public static void main(String[] args) throws Exception{
        Locale.setDefault(Locale.ENGLISH);
        NotebookServiceImpl service = new NotebookServiceImpl();
        HibernateUtil hibernateUtil = new HibernateUtil();
//        service.add(new Notebook("Ahhgxs12345", "hp", "Probook", new Date(2015,6,20), 14000.00 ));
//        System.out.println(service.findAll().toString());

    }
}
