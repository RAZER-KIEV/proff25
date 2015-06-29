package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;
import hw7.notes.domain.Vendor;

import java.util.List;
import java.util.Map;

/**
 * Created by oleg on 24.06.15.
 */
public interface StoreDao {
    Long create(Store store);
    Store read(Long ig);
    boolean update(Store store);
    boolean delete(Store store);
    List findAll();
    List<Notebook> getNotesPorced(int start, int size);
    List getNotebooksFromStore();
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(Vendor cpuVendor);
    Map getNotebooksStorePresent();
}
