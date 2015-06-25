package hw7.notes.service;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;

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
    List getNotebooksStorePresent();
    Map getSalesByDays();
    Long receive(Notebook note, int amount, double price);
    Long sale(Long storeId, int amount);
    Long createCPU(CPU cpu);
    Long createMemory(Memory memory);
    Long createVendor(Vendor vendor);
    Long createNote(Notebook notebook);
}
