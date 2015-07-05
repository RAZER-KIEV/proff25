package hw7.springnotes.service;

import hw7.springnotes.domain.*;
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 05.07.2015.
 */
public interface NotebookService {
    List getNotebooksByPortion(int size);
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(Vendor cpuVendor);
    List getNotebooksFromStore();
    Map getNotebooksStorePresent();
    Map getSalesByDays();
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);

    Long receive(Long id, int amount, double price);
    Long sale(Long storeId, int amount);
}
