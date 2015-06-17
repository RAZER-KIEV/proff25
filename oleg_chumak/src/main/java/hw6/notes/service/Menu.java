package hw6.notes.service;

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
//        System.out.println(impler.add(new Notebook("g11344gss", "nuramodjima", "BOSS", new Date(2014, 5, 12), 22125.)));
//        impler.changeSerialVendor(new Long(23), "gg5484624", "kakorornakome");
//        impler.add(new Notebook("gg45486354", "mikanomogoro", "asher", new Date(2015, 12, 5), 1500.50));
//        impler.add(new Notebook("arrr548796", "zaukanamagare", "brutto", new Date(2015, 12, 5), 1900.00));
//        impler.add(new Notebook("tr68787654", "anukanavagare", "ginzoo", new Date(2015, 12, 5), 1225.99));
        impler.delete(new Long(23));
        System.out.println(impler.findAll());
    }

    void deleteNtb(Notebook notebook){}
    void changePrice(Notebook notebook){}
    void changeSerialVendor(Notebook notebook){}
}
