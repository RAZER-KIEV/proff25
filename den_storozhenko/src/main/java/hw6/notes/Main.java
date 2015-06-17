package hw6.notes;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hw6/dao.notebook.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);

        Notebook notebook = new Notebook("21-AA-DA","Dell","N5010",new Date(Calendar.getInstance().getTimeInMillis()),50102.1);
        /**
         * create
         */
        System.out.println(notebookDao.create(notebook));
        /**
         * update
         */
        notebook.setModel("N5110");
        System.out.println(notebookDao.update(notebook));
        /**
         * delete
         */
        System.out.println(notebookDao.delete(notebook));
        /**
         * findAll
         */
        for(Notebook ntb:(List<Notebook>)notebookDao.findAll())
            ntb.print();

        factory.close();
    }
}
