package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.List;
import java.util.Map;

public interface NotebookService {
    Long create(CPU processor);
    Long create(Memory memory);
    Long create(Vendor vendor);
    Long create(Notebook notebook);

    Long receive(Long id, int amount, double price);
    Long sale(Long storeId, int amount);
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);

    List getNotebooksByPortion(int size);
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(Vendor cpuVendor);
    List getNotebooksFromStore();
    List getNotebooksStorePresent();
    Map getSalesByDays();
}