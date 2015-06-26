package hw7.notes.service;

import hw7.notes.domain.*;

/**
 * Created by Sveta on 6/26/2015.
 */
public interface NotebookService {
    Long receive(Long noteId, int amount, double price);
    Long sale(Long storeId, int amount);
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);
}
