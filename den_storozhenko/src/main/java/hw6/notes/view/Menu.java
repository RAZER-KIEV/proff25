package hw6.notes.view;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookServiceImpl;
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
        Notebook notebook = new Notebook("28-19-31","ASUS","A481",new Date(2001,6,21),16000.);
        /**
         * add
         */
        //System.out.println(notebookService.add(notebook));
        /**
         * findAll
         */
        /*for (Notebook notebook1:notebookService.findAll())
            notebook1.print();*/
        /**
         * delete
         */
        //System.out.println(notebookService.delete(2L));
        /**
         * changePrice
         */
        //notebookService.changePrice(4L, 30000);
        /**
         * changeSerialVendor
         */
        //notebookService.changeSerialVendor(4L,"AA-AA-AA","Asus");
        /**
         * deleteByModel
         */
        //System.out.println(notebookService.deleteByModel("ASPIRE"));
        /**
         * findByVendor
         */
        /*for (Notebook notebook1:notebookService.findByVendor("Dell"))
            notebook1.print();*/
        /**
         * findByPriceManufDate
         */
        /*for (Notebook notebook1:notebookService.findByPriceManufDate(45000.,new Date(Calendar.getInstance().getTimeInMillis())))
            notebook1.print();*/
        /**
         * findBetweenPriceLtDateByVendor
         */
        /*for (Notebook notebook1:notebookService.findBetweenPriceLtDateByVendor(39000.,50000.,new Date(2015,8,1),"Dell"))
            notebook1.print();*/
        hibernateUtil.closeFactory();
    }

    public void deleteNtb(Notebook notebook){
    }

    public void changePrice(Notebook notebook){
    }

    public void changeSerialVendor(Notebook notebook) {
    }

    public void deleteByModel(){
    }

    public void showByVendor(){
    }

    public void showByPriceManufDate(){
    }

    public void showBetweenPriceLtDateByVendor(){
    }
}
