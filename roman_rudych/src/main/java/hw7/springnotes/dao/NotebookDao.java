package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Роман on 25.06.2015.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List<Notebook> findAll();
    List<Notebook> finaAllAtStoresbyPortion(int portion);
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(Vendor cpuVendor);
    List getNotebooksStorePresent();
    Map<Date, Double> getSalesByDays();
}
