package hw6.notes.service;

import hw6.notes.util.HibernateUtil;
import java.util.Date;
/**
 * Created by HP on 20.06.2015.
 */
public class Menu {
   private HibernateUtil hiberUtil;
   private NotebookServiceImpl noteService;
    public Menu() {
        hiberUtil = new HibernateUtil();
        hiberUtil.initialize();
        noteService = new NotebookServiceImpl(hiberUtil.getFactory());
    }
//MAIN
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.deleteByModel("vaio");
        menu.showByVendor("Ivanov");
        menu.showByPriceManufDate(1000.00, new Date());
        menu.showBetweenPriceLtDateByVendor(800., 1100., new Date(), "Ivanov");
        menu.factoryClose();
    }
//END MAIN
    void deleteByModel(String model){
noteService.deleteByModel(model);
    }
    void showByVendor(String vendor){
noteService.findByVendor(vendor);
    }
    void showByPriceManufDate(Double price, Date date){
noteService.findByPriceManufDate(price, date);
    }
    void showBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor){
noteService.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
    }
    void factoryClose(){
        hiberUtil.factoryClose();
    }
}