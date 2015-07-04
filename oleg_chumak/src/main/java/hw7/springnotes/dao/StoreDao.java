package hw7.springnotes.dao;


import java.util.List;
import java.util.Map;

/**
 * Created by oleg on 24.06.15.
 */
public interface StoreDao {
    Long create(hw7.springnotes.domain.Store store);
    hw7.springnotes.domain.Store read(Long ig);
    boolean update(hw7.springnotes.domain.Store store);
    boolean delete(hw7.springnotes.domain.Store store);
    List findAll();
    List<hw7.springnotes.domain.Notebook> getNotesPorced(int start, int size);
    List getNotebooksFromStore();
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(hw7.springnotes.domain.Vendor cpuVendor);
    Map getNotebooksStorePresent();
}
