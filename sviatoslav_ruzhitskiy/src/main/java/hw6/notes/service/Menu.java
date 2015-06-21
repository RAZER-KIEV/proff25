package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import javafx.scene.Scene;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ПК on 18.06.2015.
 */
public class Menu {
    private static HibernateUtil hibernateUtil;
    private static SessionFactory sessionFactory;
    private static NotebookDaoImpl notebookDao;
    private static NotebookServiceImpl notebookService;


    public static void main(String[] args) {
        //prepare to work: (init)
        Locale.setDefault(Locale.ENGLISH);
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = hibernateUtil.connectToHib();
        notebookDao = new NotebookDaoImpl(sessionFactory);
        notebookService = new NotebookServiceImpl(sessionFactory,notebookDao);
        //create Date:
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY");
        Calendar cal = Calendar.getInstance();
        cal.set(2012, Calendar.JANUARY, 1);
        Date date = cal.getTime();
        //create Note:
        Notebook notebook = new Notebook((long) 2, "aszzsusz564", "ASUS", "Z564", date, Double.parseDouble("421"));
        System.out.println(notebook);
        Notebook notebook3 = new Notebook("lenvoK55-40", "Lenovo", "K55", date, Double.parseDouble("390"));

        //CRUD test
        //creation:
        //Long id = notebookDao.create(notebook);
        //System.out.println("note created! id: "+id);
        //reading:
        //Notebook notebook1 = notebookDao.read(id);
        //System.out.println("notebook readed!: "+notebook1+" end... ");
        //updating:
        boolean updated = notebookDao.update(notebook);
        System.out.println("try to update: " + notebook + " updated " + updated);
        // deleting
        // boolean deleted = notebookDao.delete(notebook);
        //System.out.println("deleted: "+deleted);
        //findAll test:
        List<Notebook> lst = notebookDao.findAll();
        for (Notebook cv : lst) {
            System.out.println(cv);
        }


    }

    void deleteNtb(Notebook notebook) {
        notebookDao.delete(notebook);

    }

    void changePrice(Notebook notebook) {
        notebookDao.update(notebook);
    }

    void changeSerialVendor(Notebook notebook) {
        notebookService.changeSerialVendor(notebook.getId(), notebook.getSerial(), notebook.getVendor());

    }

    void deleteByModel() {
        System.out.println("Enter model name to delete by model: ");
        Scanner scanner = new Scanner(System.in);
        String model = scanner.nextLine();
        System.out.println("NoteBook(s) deleted: "+notebookService.deleteByModel(model));
    }

    void showByVendor() {
        System.out.println("Enter vendor name to show by vendor: ");
        Scanner scanner = new Scanner(System.in);
        String vendor = scanner.nextLine();
        List<Notebook> resList = notebookService.findByVendor(vendor);
        for (Notebook ntb:resList){
            System.out.println(ntb);
        }
    }

    void showByPriceManufDate() {
        System.out.println("To show \"by Price Manuf Date\" enter price: ");
        Scanner scanner = new Scanner(System.in);
        String vendor = scanner.nextLine();
        List<Notebook> resList = notebookService.findByVendor(vendor);
        for (Notebook ntb:resList){
            System.out.println(ntb);
        }

    }

    void showBetweenPriceLtDateByVendor() {
    }
}