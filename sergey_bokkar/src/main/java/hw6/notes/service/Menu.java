package hw6.notes.service;

import hw6.notes.domain.Notebook;

/**
 * Created by Well on 17.06.2015.
 */
public class Menu {
    public static void main(String[] args) {

        NotebookServiceImpl nsi = new NotebookServiceImpl();
        Notebook ntb = new Notebook("145hp167", "HP", "mutant", "2015-03-18",
                25000.00);

        System.out.println(nsi.findAll());

        System.out.println(nsi.add(ntb));

        System.out.println(nsi.findAll());


    }
}
