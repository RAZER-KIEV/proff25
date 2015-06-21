package hw6.notes.dao;

import java.util.List;
import java.util.Date;
import hw6.notes.domain.Notebook;
public interface NotebookDao {

    Long create(Notebook notebook);
    Notebook read(Long id);// Be careful!
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List findAll();
    List findByModel(String model);
    List findByVendor(String vendor);
    List findByPriceManufDate(Double price, Date date);
    List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);

}

