package hw7.notes.service;

import hw7.notes.domain.*;

/**
 * Created by Роман on 25.06.2015.
 */
public interface NotebookService {
    Long receive(Long id, int amount, double price);
    Long sale(Long storeId, int amount);
    Long add(Notebook notebook);
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);
    Store getStore(Long id);
}
