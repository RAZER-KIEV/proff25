package hw6.notes.view;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;

import java.util.Date;

/**
 * Created by oleg on 17.06.15.
 */
public class Menu {
    public static void main(String[] args) {
        NotebookServiceImpl impler = new NotebookServiceImpl();
        System.out.println(impler.add(new Notebook(new Long(65598), "nuramodjima", "BOSS", new Date(2014, 5, 12), new Long(12200))));
        System.out.println(impler.findAll());
    }
}
