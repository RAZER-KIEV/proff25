package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by george on 20.06.15.
 */
public interface NotebookService {
    public Long add(Notebook notebook);
    public List<Notebook> findAll();
    boolean deleteByModel(String model);
    List<Notebook> findByVendor(String vendor);
    List<Notebook> findByPriceManufDate(Double price, Date date);
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
    void changePrice(Long id, double price);
    void changeSerialVendor(Long id, String serial, String vendor);
    boolean delete(Long id);
}
