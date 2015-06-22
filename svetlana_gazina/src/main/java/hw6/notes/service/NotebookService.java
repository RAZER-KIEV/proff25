package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Sveta on 6/21/2015.
 */
public interface NotebookService {
    public Long add(Notebook notebook);
    public List<Notebook> findAll();
    public void changePrice(Long id, double price);
    public void changeSerialVendor(Long id, String serial, String vendor);
    public boolean delete(Long id);
    public boolean deleteByModel(String model);
    public List<Notebook> findByVendor(String vendor);
    public List<Notebook> findByPriceManufDate(Double price, Date date);
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);

}
