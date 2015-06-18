package hw6.notes.service;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by oleg on 17.06.15.
 */
public class Menu {

    public static void main(String[] args) {
        NotebookServiceImpl impler = new NotebookServiceImpl();
//        System.out.println(impler.add(new Notebook("g11344gss", "nuramodjima", "BOSS", new Date(2014, 5, 12), 22125.)));
//        impler.changeSerialVendor(new Long(23), "gg5484624", "kakorornakome");
//        impler.add(new Notebook("gg45486354", "mikanomogoro", "asher", new Date(114, 11, 5), 1500.50));
//        impler.add(new Notebook("arrr548796", "zaukanamagare", "brutto", new Date(114, 11, 5), 1900.00));
//        impler.add(new Notebook("tr68787654", "anukanavagare", "ginzoo", new Date(114, 11, 5), 1225.99));
//        System.out.println(impler.findAll());
//        impler.add(new Notebook("ggrrreee445", "zataranokavoto", "BOSS", new Date(2014, 10, 12), 1799.99));
        System.out.println(impler.findBetweenPriceLtDateByVendor(1200., 2000., new Date(114, 11, 5), "zaukanamagare"));
//           impler.add(new Notebook("arrr548796", "azaza", "brutto", new Date(new Long()), 1900.00));
//        System.out.println(impler.dao.read(new Long(24)).getDate().getTime());
//        System.out.println(new Notebook("ggrrreee445", "zataranokavoto", "BOSS", new Date(114, 12, 12), 1799.99).getDate());
//        System.out.println(impler.dao.read(new Long(34)).getDate());
    }

    void deleteNtb(Notebook notebook){}
    void changePrice(Notebook notebook){}
    void changeSerialVendor(Notebook notebook){}
    void deleteByModel(){}
    void showByVendor(){}
    void showByPriceManufDate(){}
    void showBetweenPriceLtDateByVendor(){}

}
