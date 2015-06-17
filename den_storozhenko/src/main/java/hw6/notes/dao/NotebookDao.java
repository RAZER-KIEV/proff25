package hw6.notes.dao;


import hw6.notes.domain.Notebook;

import java.sql.Date;
import java.util.List;


public interface NotebookDao {
    Long create(Notebook ntb);
    Notebook read(Long ig);
    boolean update(Notebook ntb);
    boolean delete(Notebook ntb);
    List getNotebooksPorced(int start, int size);
    List findAll();
    List<Notebook> findByModel(String model);
    List<Notebook> findByVendor(String vendor);
    List<Notebook> findByPriceManufDate(Double price, Date date);
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
}
