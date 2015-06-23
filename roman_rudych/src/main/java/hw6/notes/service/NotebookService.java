package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Роман on 21.06.2015.
 */
interface NotebookService {
    Long add(Notebook notebook);
    List findAll();
    void changePrice(Long id, double price);
    void changeSerialVendor(Long id, String serial, String vendor);
    boolean delete(Long id);
    boolean deleteByModel(String model);
    List findByVendor(String vendor);
    List findByPriceManufDate(Double price, Date date);
    List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
}
