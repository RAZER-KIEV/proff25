package hw6.notes.service;

import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sveta on 6/21/2015.
 */
public class Menu {
    public static void main(String[] args) {
        SessionFactory factory = Menu.getFactory();
        NotebookServiceImpl ndService = new NotebookServiceImpl(factory);
        Notebook notebook = new Notebook(new BigDecimal(12400), "ASUS", "ASP348567", "Slim", new Date(12-10-2014));
        ndService.add(notebook);

    }
    public void deleteNtb(Notebook notebook){
        SessionFactory factory = Menu.getFactory();
        NotebookServiceImpl ndService = new NotebookServiceImpl(factory);
        ndService.delete(notebook.getId());
    }
    public void changePrice(Notebook notebook){
        SessionFactory factory = Menu.getFactory();
        NotebookServiceImpl ndService = new NotebookServiceImpl(factory);
        ndService.changePrice(notebook.getId(),notebook.getPrice().doubleValue());

    }
    public void changeSerialVendor(Notebook notebook){
        SessionFactory factory = Menu.getFactory();
        NotebookServiceImpl ndService = new NotebookServiceImpl(factory);
        ndService.changeSerialVendor(notebook.getId(),notebook.getSerial(), notebook.getVendor());

    }
    public void deleteByModel(String model){
        SessionFactory factory = Menu.getFactory();
        NotebookServiceImpl ndService = new NotebookServiceImpl(factory);
        ndService.deleteByModel(model);
    }
    public void showByVendor(){
        SessionFactory factory = Menu.getFactory();
        NotebookServiceImpl ndService = new NotebookServiceImpl(factory);
        List<Notebook> notebooks = ndService.findAll();
        List<String> vendors = null;
        for(Notebook nb: notebooks){
           vendors.add(nb.getVendor());
        }
        vendors.sort(Comparator.<String>naturalOrder());
        for(String vendor: vendors)
        {
            for(Notebook nb: notebooks){
                if(nb.getVendor() == vendor){
                    System.out.println(nb);
                }
            }
        }


    }
    public void showByPriceManufDate(Double price, Date date){
        SessionFactory factory = Menu.getFactory();
        NotebookServiceImpl ndService = new NotebookServiceImpl(factory);
        List<Notebook> notebooks = ndService.findByPriceManufDate(price, date);

        for(Notebook nb: notebooks){
            System.out.println(nb);
        }
    }
    public void showBetweenPriceLtDateByVendor(Double priceFrom, Double PriceTo, Date date, String vendor){
        SessionFactory factory = Menu.getFactory();
        NotebookServiceImpl ndService = new NotebookServiceImpl(factory);
        List<Notebook> notebooks = ndService.findBetweenPriceLtDateByVendor(priceFrom, PriceTo, date, vendor);

        for(Notebook nb: notebooks){
            System.out.println(nb);
        }
    }
    public static SessionFactory getFactory(){
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        return factory;

    }
}
