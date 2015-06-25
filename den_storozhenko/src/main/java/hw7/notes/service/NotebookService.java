package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.List;
import java.util.Map;

public interface NotebookService {
    Long receive(Long id, int amount, double price);
    Long sale(Long storeId, int amount);
    Long createCPU(CPU cpu);
    Long createMemory(Memory memory);
    Long createVendor(Vendor vendor);
    Long createNotebook(Notebook notebook);
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);
    List getNotebooksByPortion(int size);
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(Vendor cpuVendor);
    List getNotebooksFromStore();
    Map getNotebooksStorePresent();
    Map getSalesByDays();
}
