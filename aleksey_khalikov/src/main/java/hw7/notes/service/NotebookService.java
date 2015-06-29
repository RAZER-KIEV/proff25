package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.Map;
import java.util.List;

/**
 * Created by GFalcon on 25.06.15.
 */
public interface NotebookService {
    Long receive(Long noteId, int amount, double price);
    Long sale(Long storeId, int amount);
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);
    List<Notebook> getNotebooksByPortion(int size);
    List<Notebook> getNotebooksGtAmount(int amount);
    List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor);
    List<Notebook> getNotebooksFromStore();
    Map getNotebooksStorePresent();
    Map getSalesByDays();
}
