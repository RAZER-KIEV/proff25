package hw6.notes;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


/**
 * Created by oleg on 17.06.15.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        NotebookDaoImpl impler = new NotebookDaoImpl(factory);
        impler.create(new Notebook(new Long(5543335), "idunfiro", "dreadnote", "22-05-2012",new Long(5200)));
//        impler.delete(impler.read(new Long(1)));
        System.out.println(impler.findAll());
    }
}
