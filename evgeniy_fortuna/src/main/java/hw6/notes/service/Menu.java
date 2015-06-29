package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Menu {
    private NotebookService notebookService;
    private SessionFactory factory;
    private Scanner scan;

    public static void main(String[] args) {
        Menu menu = new Menu();
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernateHW6.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        menu.factory = cfg.buildSessionFactory(standardServiceRegistry);
        menu.notebookService = new NotebookServiceImpl(new NotebookDaoImpl(menu.factory));
        menu.scan = new Scanner(System.in);
        menu.selectMenu();
    }

    public void selectMenu() {
        int choise = 0;
        do {
            showMenu();
            choise = getInput();

            switch (choise) {
                case 1: showAllNotebooks();
                    break;
                case 2: addNewNotebook();
                    break;
                case 3: System.exit(0);
                    factory.close();
                    break;
            }
        } while (choise != 3);
    }

    public void showAllNotebooks() {
        System.out.println(notebookService.findAll());
    }

    public void addNewNotebook() {
        System.out.println("Input serial");
        String serial = scan.nextLine();
        System.out.println("Input vendor");
        String vendor = scan.nextLine();
        System.out.println("Input model");
        String model = scan.nextLine();
        Date date = scanDateWithRetry("Input date");
        System.out.println("Input price");
        double price = scan.nextDouble();
        Notebook notebook = new Notebook(serial, vendor, model, date, price);
        System.out.println("Added user " + notebook);
        notebookService.add(notebook);
    }

    public void deleteNtb(Notebook notebook) {
        notebookService.delete(notebook.getId());
    }

    public void changePrice(Notebook notebook) {
        notebookService.changePrice(notebook.getId(), notebook.getPrice());
    }
    public void changeSerialVendor(Notebook notebook) {
        notebookService.changeSerialVendor(notebook.getId(), notebook.getSerial(), notebook.getModel());
    }

    private Date scanDateWithRetry(String message) {
        final String DATE_FORMAT = "mm.dd.yyyy";
        Date date = null;
        String dateStr;
        do {
            System.out.println(message);
            dateStr = scan.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException pe) {
                System.out.println("Illegal date format, correct format is \'" + DATE_FORMAT + "\', try again");
            }
        } while (date == null);
        return date;
    }

    private double scanDoubleWithRetry(String message) {
        return 0;
    }

    private int getInput() {
        int res = -1;
        String inputStr = scan.nextLine();
        try {
            res = Integer.parseInt(inputStr);
        } catch (NumberFormatException nfe) {
            System.out.println("String " + inputStr + " is not a number");
        }
        return res;
    }

    public void showMenu() {
        System.out.println("-----------------");
        System.out.println("1. Show all Notebooks");
        System.out.println("2. Add new Notebook");
        System.out.println("3. Exit");
    }
}
