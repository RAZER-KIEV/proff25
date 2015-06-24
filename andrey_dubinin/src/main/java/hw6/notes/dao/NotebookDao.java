package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.sql.Date;
import java.util.List;

/**
 * Created by jax on 21.06.15.
 */
public interface NotebookDao {
    Long create(Notebook ntb);
    Notebook read(Long id);
    boolean update(Notebook ntb);
    boolean delete(Notebook ntb);
    List<Notebook> findAll();
    List<Notebook> findByModel(String model);
    List<Notebook> findByVendor(String vendor);
    List<Notebook> findByPriceManufDate(Double price,Date date);
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom,Double priceTo, Date date,String vendor);
}
