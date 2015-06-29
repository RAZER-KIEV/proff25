package hw6.notes.view;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jeckgehor on 20.06.2015.
 */
public class Menu {
    public static void main (String[] args) {
        NotebookServiceImpl notebookService = new NotebookServiceImpl();
        Date date = Calendar.getInstance().getTime();
        Notebook ntb1 = new Notebook(3L, "UUU99", "Apple", "5OK", 333.33, date);
        // notebookService.add(ntb1));
        // System.out.println(notebookService.findAll());
       //  changePrice(ntb1);
       // changeSerialVendor(ntb1);
       // deleteNtb(ntb1);
    }

    public static void deleteNtb(Notebook notebook){
        NotebookServiceImpl notebookService = new NotebookServiceImpl();
        notebookService.delete(notebook.getId());
    }

    public static void changePrice(Notebook notebook){
        NotebookServiceImpl notebookService = new NotebookServiceImpl();
        notebookService.changePrice(notebook.getId(), notebook.getPrice());
    }

    public static void changeSerialVendor(Notebook notebook){
        NotebookServiceImpl notebookService = new NotebookServiceImpl();
        notebookService.changeSerialVendor(notebook.getId(),notebook.getSerial(),notebook.getVendor());
    }


}
