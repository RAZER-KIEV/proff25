package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by ПК on 18.06.2015.
 */
public class Menu {
    public static void main(String[] args) {
        //prepare to work:
        Locale.setDefault(Locale.ENGLISH);
        HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory sessionFactory = hibernateUtil.connectToHib();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(sessionFactory);
                //create Date:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY");
                Calendar cal = Calendar.getInstance();
                cal.set(2012, Calendar.JANUARY, 1);
                Date date = cal.getTime();
                //dateFormat.format(date);
                //create Note:
                Notebook notebook = new Notebook((long) 2,"aszzsusz564","ASUS","Z564",date, Double.parseDouble("421"));
        System.out.println(notebook);
                Notebook notebook3= new Notebook("lenvoK55-40", "Lenovo", "K55", date,Double.parseDouble("390"));

        //CRUD test
            //creation:
            //Long id = notebookDao.create(notebook);
            //System.out.println("note created! id: "+id);
            //reading:
            //Notebook notebook1 = notebookDao.read(id);
            //System.out.println("notebook readed!: "+notebook1+" end... ");
            //updating:
            boolean updated = notebookDao.update(notebook);
            System.out.println("try to update: "+notebook+" updated "+updated);
            // deleting
           // boolean deleted = notebookDao.delete(notebook);
            //System.out.println("deleted: "+deleted);
        //findAll test:
            List<Notebook> lst= notebookDao.findAll();
            for (Notebook cv:lst){
                System.out.println(cv);
            }


    }
    void deleteNtb(Notebook notebook){}
    void changePrice(Notebook notebook){}
    void changeSerialVendor(Notebook notebook){}

}
