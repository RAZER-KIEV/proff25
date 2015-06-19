package hw6.notes.view;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.util.HibernateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    private static NotebookServiceImpl service;
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        HibernateUtil util = new HibernateUtil();
        util.createSessionFactory();
        service = new NotebookServiceImpl(util.getFactory());
    }

    public void deleteNtb(Notebook notebook){
    }

    public void changePrice(Notebook notebook){
    }

    public void changeSerialVendor(Notebook notebook) {
    }

    public void deleteByModel(){
        System.out.println("Enter Model Notebook:");
        Scanner in= new Scanner(System.in);
        String model= in.nextLine();
        service.deleteByModel(model);

    }

    public void showByVendor(){
        System.out.println("Enter Vendor:");
        Scanner in = new Scanner(System.in);
        String vendor= in.nextLine();
        service.deleteByVendor(vendor);
    }

    public void showByPriceManufDate(){
    }

    public void showBetweenPriceLtDateByVendor(){
    }
}
