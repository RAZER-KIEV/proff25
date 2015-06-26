package hw7.notes.service;

import hw7.notes.domain.*;

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
}