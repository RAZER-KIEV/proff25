package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;

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
    List findAll();
    List getNotebooksByPortion(int portion);
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(Vendor cpuVendor);
    Map getNotebooksStorePresent();
    Map getSalesByDays();
}
