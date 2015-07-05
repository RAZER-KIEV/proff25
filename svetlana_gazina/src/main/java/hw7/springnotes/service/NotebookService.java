package hw7.springnotes.service;

import hw7.notes.domain.Vendor;
import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Store;

import java.util.List;
import java.util.Map;

/**
 * Created by Sveta on 7/5/2015.
 */
public interface NotebookService {
    List getNotebooksByPortion(int size);
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(Vendor cpuVendor);
    List getNotebooksFromStore();
    List getNotebooksStorePresent();
    Map getSalesByDays();
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);
    Long receive(Long noteId, int amount, double price);
    Long sale(Long storeId,int amount);
}
