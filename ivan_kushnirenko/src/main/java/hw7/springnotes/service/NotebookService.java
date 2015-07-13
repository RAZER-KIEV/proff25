package hw7.springnotes.service;

import hw7.springnotes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by ivan on 05.07.15.
 * List getNotebooksByPortion(int size)
 * List getNotebooksGtAmount(int amount)
 * List getNotebooksByCpuVendor(Vendor cpuVendor)
 * List getNotebooksFromStore()
 * List getNotebooksStorePresent()
 * Map getSalesByDays()
 * boolean updateCPU(CPU cpu)
 * boolean updateMemory(Memory memory)
 * boolean updateVendor(Vendor vendor)
 * boolean updateNotebook(Notebook notebook)
 * boolean removeFromStore(Store store, int amount)
 */
public interface NotebookService {

    Long receive(Long id, int amount, double price);

    Long sale(Long storeId, int amount);

    Long createCPU(CPU cpu);

    Long createMemory(Memory memory);

    Long createVendor(Vendor vendor);

    Long createNotebook(Notebook notebook);

    Vendor getVendor(Long id);

    CPU getCPU(Long id);

    Memory getMemory(Long id);

    Notebook getNotebook(Long id);

    Store getStore(Long id);

    boolean updateCPU(CPU cpu);

    boolean updateMemory(Memory memory);

    boolean updateVendor(Vendor vendor);

    boolean updateNotebook(Notebook notebook);

    boolean removeFromStore(Store store, int amount);

    List getNotebooksByPortion(int size);

    List getNotebooksGtAmount(int amount);

    List getNotebooksByCpuVendor(Vendor cpuVendor);

    List getNotebooksFromStore();

    Map getNotebooksStorePresent1();

    List getNotebooksStorePresent();

    Map getSalesByDays();

}
