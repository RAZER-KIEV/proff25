package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by just1ce on 29.06.2015.
 */
public interface NotebookService {
    Long receive(Long id, int amount, double price);
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
    Map<Notebook, Integer>  getNotebooksStorePresent();
    Map<Notebook, Integer> getSalesByDays();
}
