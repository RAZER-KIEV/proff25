package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by jax on 21.06.15.
 */
public interface NotebookService {
    Long add(Notebook ntb);
    List<Notebook> findAll();
    void changePrice(long id, double price);
    void changeSerialVendor(long id,String serial,String vendor);
    boolean delete(long id);
    boolean deleteByModel(String model);
    List<Notebook> findByVendor(String vendor);
    List<Notebook> findByPriceManufDate(Double price, Date date);
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo,Date date,String vendor);
}
