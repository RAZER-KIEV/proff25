package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;
import hw7.springnotes.domain.Vendor;
import java.util.List;
import java.util.Map;

public interface StoreDao {
    Long create(Store store);
    Store read(Long ig);
    boolean update(Store store);
    boolean delete(Store store);
    List findAll();
    List getNotebooksByPortion(int size);

    List getNotebooksGtAmount(int amount);

    List getNotebooksByCpuVendor(Vendor cpuVendor);

    List getNotebooksFromStore();

    Map getNotebooksStorePresent();
}
