package hw7.notes.dao;

import hw7.notes.domain.Store;
import hw7.notes.domain.Vendor;

import java.util.List;
import java.util.Map;

public interface StoreDao {
    Long create(Store store);
    Store read(Long id);
    boolean update(Store store);
    boolean delete(Store store);
    List getStoresPorced(int start, int size);
    List findAll();
    List getNotebooksByPortion(int size);
    List getNotebooksFromStore();
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(Vendor cpuVendor);
    Map getNotebooksStorePresent();
}
