package hw6.notes.service;

import hw6.notes.util.HibernateUtil;

import java.util.Locale;

/**
 * Created by george on 20.06.15.
 */
public class Menu {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.createSessionFactory();

        NotebookServiceImpl notebookService = new NotebookServiceImpl();
//        Notebook notebook = new Notebook();
    }

    private void deleteByModel(){

    }
    private void showByVendor(){

    }
    private void showByPriceManufDate(){

    }
    private void showBetweenPriceLtDateByVendor(){

    }
}
