package hw7.springnotes.service;


import hw7.springnotes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by oleg on 24.06.15.
 */
public interface NotebookService {
    List getNotebooksByPortion(int size);
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(Vendor cpuVendor);
    List getNotebooksFromStore();
    Map getNotebooksStorePresent();
    Map getSalesByDays();
    Long receive(Long id, int amount, double price);
    Long sale(Long storeId, int amount);
    Long receive(Notebook note, int amount, double price);
    Long createCPU(CPU cpu);
    Long createMemory(Memory memory);
    Long createVendor(Vendor vendor);
    Long createNote(Notebook notebook);
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);
}
