package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.List;

public interface NotebookService {
    Long createCPU(CPU cpu);
    Long createMemory(Memory memory);
    Long createVendor(Vendor vendor);
    Long createNotebook(Notebook notebook);
    CPU getCPU(Long id);
    Memory getMemory(Long id);
    Vendor getVendor(Long id);
    Notebook getNotebook(Long id);
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    Long receive(Notebook note, int amount, int price);
    Long sale(Long storeId, int amount);
    boolean removeFromStore(Store store, int amount);
    List getAllVendorNames();
    List listAllVendors();
    List listAllCPUs();
    List listAllMemories();
    List listAllNotebooks();
    List listAllStores();
    List listAllSales();
}
